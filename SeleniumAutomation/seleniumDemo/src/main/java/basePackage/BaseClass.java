package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
	    prop= new Properties();
	    FileInputStream  fis=new FileInputStream("C:\\Users\\HARISAP\\eclipse-workspace\\SeleniumAutomation\\seleniumDemo\\src\\main\\java\\resourse\\data.properties");
		prop.load(fis);
		String browseName=prop.getProperty("browser");
		
		if(browseName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HARISAP\\AutomationSetup\\chromeDriver\\chromedriver.exe");
		    driver =new ChromeDriver();

		}else if(browseName.equalsIgnoreCase("firefox")) {
			
			
		}else {
			//specified driver is not found
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
		
}
