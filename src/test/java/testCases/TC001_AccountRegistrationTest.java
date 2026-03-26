package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPageFunmatch;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationOpenCart;
import testBase.BaseClass; 
public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() throws InterruptedException
	{		

		Thread.sleep(5000);
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.ClickOnRegister();
		
		RegistrationOpenCart Reg=new RegistrationOpenCart(driver);
		Reg.SetFname(randomalphabets());
		//Reg.SetFname(p.getProperty("FirstName"));
		Reg.SetLname(randomalphabets());
		//Reg.SetLname(p.getProperty("Lastname"));
		Reg.SetEmail(randomEmail());
		//Reg.SetEmail(p.getProperty("Email"));
		Reg.SetMobNo(randomnumber());
		//Reg.SetMobNo(p.getProperty("Tel"));
		Reg.SetPwd(randompwd());
		//Reg.SetPwd(p.getProperty("Password"));
		Reg.SetCnfPwd(randompwd());
		//Reg.SetCnfPwd(p.getProperty("CnfPassword"));
		Reg.ClickOnChkBox();
		Thread.sleep(5000);
		Reg.ClickOnContinue();
		
		
		
		/*try
		{
		//HomePage
		Thread.sleep(5000);
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login
		LoginPage Lgn=new LoginPage(driver);
		Lgn.Username(p.getProperty("Uname"));
		Lgn.Password(p.getProperty("Pwd"));
		Lgn.ClickOnLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyaccountPageExists();
		
		Assert.assertTrue(targetPage);
					//OR
		//Assert.assertEquals(targetPage, true, "Login failed");
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		*/
		
		
		/*   //Funmatch
		Thread.sleep(5000);
		HomePage hp=new HomePage(driver);
		//hp.clickRegister();
		 
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase()); //To create random name with the first letter as caps
		regpage.setEmail(randomString()+"@gmail.com"); //To randomly generated email
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		
		regpage.setMobNum(6789+randomNumber());
		regpage.clickContinue();
		regpage.setOTPNumber1("1");
		regpage.setOTPNumber2("2");
		regpage.setOTPNumber3("3");
		regpage.setOTPNumber4("4");
		regpage.setOTPNumber5("5");
		regpage.setOTPNumber6("6");
		Thread.sleep(5000);
		regpage.setClickVerify();
		regpage.setClickStartnow();
		*/
		
	}
	
}