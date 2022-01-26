package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="ss")
	WebElement cityTextBox ; 
	
	@FindBy(className="xp__dates-inner")
	WebElement datesBox ;
	
	@FindBy(xpath="//div[@class='bui-calendar__wrapper'][1]/div")
	WebElement currentMonthLbl;
	
	@FindBy(xpath="//div[@class='bui-calendar__wrapper'][1]/div")
	WebElement nextMonthLbl;
	
	@FindBy(className="xp__guests__count")
	WebElement guestsCountBox ; 
	
	@FindBy(xpath="//button[@aria-label='Decrease number of Adults']//following-sibling::span[@class='bui-stepper__display']")
	WebElement noOfAdultsLabel ;
	
	@FindBy(xpath="//button[@aria-label='Increase number of Adults']")
	WebElement incAdultsBtn ;
	
	@FindBy(xpath="//button[@aria-label='Decrease number of Adults']")
	WebElement decAdultsBtn ;
	
	@FindBy(xpath="//button[@aria-label='Decrease number of Children']//following-sibling::span[@class='bui-stepper__display']")
	WebElement noOfChildrenLabel ;
	
	@FindBy(xpath="//button[@aria-label='Increase number of Children']")
	WebElement incChildrenBtn ;
	
	@FindBy(xpath="//button[@aria-label='Decrease number of Children']")
	WebElement decChildrenBtn ;
	
	@FindBy(xpath="//select[@name='age']/option[3]")
	WebElement oneYearChildAge;
	
	@FindBy(xpath="//div[@class='xp__button']/div[2]/button")
	WebElement searchBtn;
	
	public void insertCity(String city) {
		setTextElementText(cityTextBox, city);
	}
	
	public void setNumberOfGuests(int noOfAdults, int noOfChildren)
	{
		clickButton(guestsCountBox);
		int adults = getElementTextAsInteger(noOfAdultsLabel);
		int children = getElementTextAsInteger(noOfChildrenLabel);
		
		for(int clicks =0; clicks<Math.abs(noOfAdults - adults); clicks++)
		{
			if(noOfAdults > adults)
			{
				clickButton(incAdultsBtn);
			}
			else
			{
				clickButton(decAdultsBtn);
			}
		}
		
		for(int clicks =0; clicks<Math.abs(noOfChildren - children); clicks++)
		{
			if(noOfChildren > children)
			{
				clickButton(incChildrenBtn);
			}
			else
			{
				clickButton(decChildrenBtn);
			}
		}
		
		clickButton(oneYearChildAge);
	}
	
	public void searchForHotels()
	{
		clickButton(searchBtn);
	}
	
	public void setCheckinAndCheckoutDatesNextWeek()
	{
		clickButton(datesBox);
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		cal.add(Calendar.DATE, +7);
		int checkInMonth = cal.get(Calendar.MONTH);
		int checkInDay = cal.get(Calendar.DAY_OF_MONTH);
		String month = checkInMonth < 10 ? "0" + (checkInMonth+1) : Integer.toString(checkInMonth);
		String day = checkInDay < 10 ? "0" + (checkInDay) : Integer.toString(checkInDay);
		String checkInDate = cal.get(Calendar.YEAR) + "-" + month + "-" + day;
		System.out.println("first date: " + "//td[@data-date='"+checkInDate+"']");
		
		clickUsingJsExecuter(By.xpath("//td[@data-date='"+checkInDate+"']"));
		
		cal.add(Calendar.DATE, +6);
		int checkOutMonth = cal.get(Calendar.MONTH);
		int checkOutDay = cal.get(Calendar.DAY_OF_MONTH);
		month = checkOutMonth < 10 ? "0" + (checkOutMonth+1) : Integer.toString(checkOutMonth);
		 day = checkOutDay < 10 ? "0" + (checkOutDay) : Integer.toString(checkOutDay);
		String checkOutDate = cal.get(Calendar.YEAR) + "-" + month + "-" + day;
		System.out.println("Second date: " + checkOutDate);
		
		clickUsingJsExecuter(By.xpath("//td[@data-date='"+checkOutDate+"']"));
		
	}
}
