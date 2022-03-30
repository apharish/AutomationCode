package homePageTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageObject.HomePage;

public class HomePageNavigation extends BaseClass{

	@Test
	public void navigationToHomePage() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("baseUrl"));
		HomePage home=new HomePage(driver);
		//home.getSearchBox().click();
		//home.getSearchBox().sendKeys("selenium");
		home.getSeleniumIcon().click();
	}
}
