package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeaHRM {
	WebDriver driver;
	
	@Test(priority=-1)
	void OpenApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	void TestLogo()
	{
	boolean img=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	System.out.println("Logo is displaying:"+img);
	
	WebElement img1=driver.findElement(By.xpath("//img[@alt='company-branding']"));
	System.out.println(img1.getText());
	}

	@Test (priority=1)
	void Login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test (priority=50)
	void close() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}
