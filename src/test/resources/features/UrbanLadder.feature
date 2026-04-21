Feature: UrbanLadder End to End Automation

  Scenario: Validate Bookshelves, Collections and Gift Card flow
    Given user is on UrbanLadder home page
    When user searches for "Bookshelves"
    And user applies storage and price filters
    And user views collections submenu
    Then user validates gift card flow
