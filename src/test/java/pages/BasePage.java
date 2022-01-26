package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class BasePage {

	protected WebDriver driver; 

	public BasePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	protected WebElement getElement(By selector)
	{
		Wait<WebDriver> wait = 
				new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(
				webdriver-> {
					return webdriver.findElement(selector);
				}
				);
		
	}
	
	
	void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void clickButton(WebElement button) 
	{
		button.click();
	}
	
	protected void setTextElementText(WebElement textElement , String value)
	{
		textElement.sendKeys(value);
	}
	
	protected void clearText(WebElement element) 
	{
		element.clear();
	}
	
	protected int getElementTextAsInteger(WebElement element) {
		return Integer.parseInt(element.getText());
	}
	
	protected String getElementText(WebElement element) {
		return element.getText();
	}
	
	protected void clickUsingJsExecuter(By selector)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void goToUrl(String url)
	{
		driver.get(url);
	}
}

