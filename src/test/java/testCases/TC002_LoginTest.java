package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void Verify_Login() throws InterruptedException
	{
	try
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
	
	/*
	@Test
	public void Verify_Login() throws InterruptedException
		{
		//try
		//{
		//HomePage
		Thread.sleep(5000);
		HomePage hp=new HomePage(driver);
		hp.clickLogin();
		
		//Login
		LoginPage Lgn=new LoginPage(driver);
		Lgn.Username(p.getProperty("Uname"));
		Lgn.Password(p.getProperty("Pwd"));
		Lgn.ClickOnLogin();
		
		//Deposit Page
		DepositPage dep=new DepositPage(driver);
		boolean targetpage=dep.isdepositPageExists();
		
		Assert.assertTrue(targetpage);
		
		//Logout
		dep.ClickMyAccount();
		dep.ClickOnLogout();
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	 	*/
	}
}
