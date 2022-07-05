Feature: Test Register Functionality

Scenario: A user wants to signup
    Given a user is on signup page
    When a user clicks on signup option
    When  a user enters the correct username and correct password and confirm password
    When a user checks on are you admin option
    When clicks on signup button
    Then a user is navigated to index page