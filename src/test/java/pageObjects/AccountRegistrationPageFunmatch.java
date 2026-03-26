package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPageFunmatch extends BasePage{
	
	public AccountRegistrationPageFunmatch(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter your username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@placeholder='Enter your email address']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@class='fm-input_field fm-password_r cls__password_r reg_field fm_emj_is password_strength_indicator']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@class='fm-input_field fm-phoneNumber_r numberInpt mobile_validation mobileValidation cls__fm-number_r reg_field fm-regi-en-ph-n']")
	WebElement txtMobileNum;
	
	@FindBy(xpath="//button[normalize-space()='Register']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[1]")
	WebElement OTPfiled1;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[2]")
	WebElement OTPfiled2;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[3]")
	WebElement OTPfiled3;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[4]")
	WebElement OTPfiled4;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[5]")
	WebElement OTPfiled5;
	
	@FindBy(xpath="//div[@class='fm-register-otp-page fm_register_otpverify']//input[6]")
	WebElement OTPfiled6;
	
	@FindBy(xpath="//a[@class='fm_butn_popup fm_save_color cls_otp_verify']")
	WebElement btnverify;
	
	@FindBy(xpath="//a[normalize-space()='Start now']")
	WebElement btnStartnow;
	
	
	public void setFirstName(String fname) {
		txtUsername.sendKeys(fname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setMobNum(String MobNo) {
		txtMobileNum.sendKeys(MobNo);
	}
	
	public void clickContinue() {
	
	// Solution 1
	//btnContinue.click();
			//OR
	// Solution 2
	//btnContinue.submit();
			//OR
	// Solution 3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
			//OR
	// Solution 4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("argument[0].click();", btnContinue);
			//OR
	// Solution 5
	//btnContinue.sendKeys(Keys.RETURN);	
			//OR
		
	// Solution 6
	WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public void setOTPNumber1(String OTPnum) {
		OTPfiled1.sendKeys(OTPnum);
	}
	
	public void setOTPNumber2(String OTPnum) {
		OTPfiled2.sendKeys(OTPnum);
	}
	
	public void setOTPNumber3(String OTPnum) {
		OTPfiled3.sendKeys(OTPnum);
	}
	
	public void setOTPNumber4(String OTPnum) {
		OTPfiled4.sendKeys(OTPnum);
	}
	
	public void setOTPNumber5(String OTPnum) {
		OTPfiled5.sendKeys(OTPnum);
	}
	
	public void setOTPNumber6(String OTPnum) {
		OTPfiled6.sendKeys(OTPnum);
	}
	
	public void setClickVerify() {
		btnverify.click();
	}
	
	public void setClickStartnow () {
		btnStartnow.click();
	}
		
}