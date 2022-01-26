package pages;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-testid='property-card']")
	List<WebElement> properties;
	
	public boolean verifySearchResultsDisplayed()
	{
		return properties.size() >=1 ? true : false;
	}

}
