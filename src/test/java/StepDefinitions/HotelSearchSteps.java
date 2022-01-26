package StepDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import pages.*;

public class HotelSearchSteps {

	
	HomePage home = new HomePage(Hooks.getDriver());
	SearchResultsPage results = new SearchResultsPage(Hooks.getDriver());
	
	@When("^I navigate to booking website$")
	public void i_navigate_to_booking_website() {
	    home.goToUrl("https://www.booking.com/");
	    
	}

	@And("^I search for \"([^\"]*)\" city$")
	public void i_search_for_city(String city) {
		home.insertCity(city);
	}

	@And("The check-in and check-out dates are next week")
	public void the_check_in_and_check_out_dates_are_next_week() {
		home.setCheckinAndCheckoutDatesNextWeek();		
	}

	@And("The needed room is for {int} adults and {int} Children")
	public void the_needed_room_is_for_adults_and_children(int noOfAdults, int noOfChildren) {
		home.setNumberOfGuests(noOfAdults, noOfChildren);
	}
	
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		home.searchForHotels();
	}

	@Then("The system shows search results")
	public void the_system_shows_search_results() {
				boolean hasProperties = results.verifySearchResultsDisplayed();
		assertTrue(hasProperties);
	}


}
