package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	 //OPENCART APPLICATION
	//1. Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//2. Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	//3. Action method
	public void clickMyaccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void ClickOnRegister()
	{
		lnkRegister.click();
	}
	
	/* FUNMATCH APPLICATION
	 
	//1. Constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//2. Locators
	@FindBy(xpath="//div[contains(@class,'sv_login_btn_cont_name cls_signup')]")
	WebElement lnkRegister;
	
	@FindBy(xpath="//div[@class='sv_login_btn_cont_name']")
	WebElement lnkLogin;
	
	//3. Action method
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	*/
}