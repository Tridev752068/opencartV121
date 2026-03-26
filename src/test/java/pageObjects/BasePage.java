package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{

	WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver=driver; //This is representating the particular class
		PageFactory.initElements(driver, this); //Page Factory is a design pattern in Selenium used to initialize web elements in the Page Object Model (POM). It makes the code cleaner, more readable, and maintainable.
	}
	
	//**For every PageObject class we need a constructor. So instead of creating for every page object class we can take this constructor as a "Parent" class.
	
}