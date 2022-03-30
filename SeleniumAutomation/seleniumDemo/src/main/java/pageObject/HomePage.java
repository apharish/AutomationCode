package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	By searchBox=By.id("gsc-i-id1");
	
	@FindBy(xpath="//img[@src='https://www.guru99.com/images/home/selenium-logo.png']")
	WebElement seleniumIcon;
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

	public WebElement getSeleniumIcon() {
		return seleniumIcon;
	}
}
