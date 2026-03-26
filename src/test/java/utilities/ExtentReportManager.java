 package utilities;
  
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;
    
    String repName;

    public void onStart(ITestContext testContext) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        
        sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); // Title of report
        sparkReporter.config().setReportName("Functional Testing Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("Username", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
                
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty())
            extent.setSystemInfo("Groups", includedGroups.toString());
    }

    public void onTestSuccess(ITestResult result) {
    	
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups()); // to display groups in report
        test.log(Status.PASS,result.getMethod()+"Test Passed");
    }

    public void onTestFailure(ITestResult result) {
    	
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL, result.getThrowable()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgpath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgpath);
            
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+"Test Skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testcontext) {
    	
        extent.flush();
        
        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
