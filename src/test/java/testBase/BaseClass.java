package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Properties p;                                                                       

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {

        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        //remote
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities capabilities=new DesiredCapabilities();
        	//capabilities.setPlatform(Platform.WIN11); //Windows 11
        	//capabilities.setBrowserName("chrome");
        	
        	//os
        	if(os.equalsIgnoreCase("windows"))
        	{
        		capabilities.setPlatform(Platform.WIN11);
        	}
        	
        	else if(os.equalsIgnoreCase("mac"))
        	{
        		capabilities.setPlatform(Platform.WIN11);
        	}
        	else
        	{
        		System.out.println("No matching os");
        		return; 
        	}
        	
        	//browser
        	switch(br.toLowerCase())
        	{
        	case "chrome": capabilities.setBrowserName("chrome"); break;
        	case "edge": capabilities.setBrowserName("Microsoftedge"); break;
        	default : System.out.println("No matching browser"); return;
        	}
        	
        	driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
        }
        
        
      /*  //Local
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
            switch (br.toLowerCase()) 
            {
                case "chrome": driver = new ChromeDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                case "firefox": driver = new FirefoxDriver(); break;
                default: throw new RuntimeException("Invalid browser name");
            }

        }  
        */
        
        switch (br.toLowerCase()) 
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: throw new RuntimeException("Invalid browser name");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       // driver.get(p.getProperty("appURL1"));
        driver.get("https://tutorialsninja.com/demo/");
        }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    public String captureScreen(String tname) throws IOException {
    	
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File  sourceFile =takeScreenshot.getScreenshotAs(OutputType.FILE);
        
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);
        
        sourceFile.renameTo(targetFile);
        
        return targetFilePath;
    }

    public String randomalphabets() {
        return RandomStringUtils.randomAlphabetic(5);
        }
    public String randomEmail() {
        return RandomStringUtils.randomAlphanumeric(4) + "@gmail.com";
    }

    public String randomnumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randompwd() {
        return RandomStringUtils.randomAlphanumeric(5) + "@";
    }
    
}	
