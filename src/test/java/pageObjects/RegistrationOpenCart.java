package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationOpenCart extends BasePage{
	
	public RegistrationOpenCart (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement lnkFname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lnkLname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement lnkemail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement lnktele;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement lnkpwd;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement lnkCnfpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement lnkchkbox;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement lnkcontinue;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Confmsg;
	
	public void  SetFname (String firstname)
	{
		lnkFname.sendKeys(firstname);
	}
	
	public void  SetLname(String Lastname)
	{
		lnkLname.sendKeys(Lastname);
	}
	
	public void  SetEmail(String Email)
	{
		lnkemail.sendKeys(Email);
	}
	
	public void  SetMobNo(String Mob)
	{
		lnktele.sendKeys(Mob);
	}
	
	public void  SetPwd(String Pwd)
	{
		lnkpwd.sendKeys(Pwd);
	}
	
	public void  SetCnfPwd(String ConfmPwd)
	{
		lnkCnfpwd.sendKeys(ConfmPwd);
	}
	
	public void  ClickOnChkBox()
	{
		lnkchkbox.click();
	}
	
	public void  ClickOnContinue()
	{
		lnkcontinue.click();
	}
	
	public void ClickOnLogout()
	{
		lnkLogout.click();
	}
	
	public String Confirmationmsg()
	{
		return Confmsg.getText();
	}

}
