Feature: Test Login Functionality

Background: 
    Given a user is on index page

Scenario: A user wants to login
    When  a user enters the correct username and correct password
    And clicks on login button
    Then a user is navigated to dashboard page

Scenario: A user wants to signup
    When a user clicks on signup option
    When  a user enters the correct username and correct password and confirm password
    When a user checks on are you admin option
    And clicks on signup button
    Then a user is navigated to index page