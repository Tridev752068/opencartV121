package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
	/* Data is valid  -login success - test pass -> Logout
	   Data is valid  -login failed - test fail
	  
	   Data is invalid  -login success - test fail -> Logout
	   Data is invalid  -login success - test pass 
	 */
import utilities.DataProviders;
	
	public class TC003_LoginDDT extends BaseClass{
	
		@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"Datadriven", "Master"}) //getting data provider from different class
		public void Verify_Login(String email, String pwd, String exp) throws InterruptedException
			{
			//HomePage
			Thread.sleep(5000);
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			
			//Login
			LoginPage Lgn=new LoginPage(driver);
			Lgn.Username(email);
			Lgn.Password(pwd);
			Lgn.ClickOnLogin();
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyaccountPageExists();			
	
	/*Data is valid  -login success - test pass -> Logout
					  login failed - test fail
	  
	 Data is invalid  -login success - test fail -> Logout
	 					login success - test pass
	*/
	
	if(exp.equalsIgnoreCase("Valid")) //Data is valid  -login success - test pass -> Logout
	{
		if(targetPage==true)
		{
			Assert.assertTrue(true);
			macc.clickLogout();
		}
		else  //login failed - test fail
		{
			Assert.assertTrue(false);
		}
	}
	
	
	if(exp.equalsIgnoreCase("Invalid"))	 //Data is invalid  -login success - test fail -> Logout
	{
		Assert.assertTrue(false);
		macc.clickLogout();
	}
	else //login success - test pass
	{
		Assert.assertTrue(true);
	}
	
			}
	  }
	