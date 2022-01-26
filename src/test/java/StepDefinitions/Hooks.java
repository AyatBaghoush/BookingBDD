package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;

public class Hooks {

	static WebDriver driver = null;

	@Before
	public void browserSetup()
	{
		String projPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", projPath+ "/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
