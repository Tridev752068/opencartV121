package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	/*	FUNMATCH APPLICATION
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='fm-username_l']")
	WebElement lnkUname;
	
	@FindBy(xpath="//input[@class='fm-input_field fm-password_r loginPassword fm_emj_is']")
	WebElement lnkPwd;
	
	@FindBy(xpath="//button[@class='fm-login_btn cls_loginBtn_sme']")
	WebElement lnkLogin;
	
	public void Username (String uname)
	{
		lnkUname.sendKeys(uname);
	}
	
	public void Password (String pwd)
	{
		lnkPwd.sendKeys(pwd);
	}
	
	public void ClickOnLogin ()
	{
		lnkLogin.click();
	}
	*/
	
	
	//OPENCART APPPLICATION
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement lnkUname;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement lnkPwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement lnkLogin;
	
	public void Username (String uname)
	{
		lnkUname.sendKeys(uname);
	}
	
	public void Password (String pwd)
	{
		lnkPwd.sendKeys(pwd);
	}
	
	public void ClickOnLogin ()
	{
		lnkLogin.click();
	}
	
}
