@TASK-Part1
Feature: Hotel search feature tests

  @tag1
  Scenario Outline: Search for hotels in Malaga city
    When I navigate to booking website
    And I search for "<city>" city
    And The check-in and check-out dates are next week
    And The needed room is for <NumOfAdults> adults and <NumOfChildren> Children
    And I click on the search button
    Then The system shows search results

		Examples: 
      | city   | NumOfAdults | NumOfChildren |
      | Malaga | 2           |  1            |
  