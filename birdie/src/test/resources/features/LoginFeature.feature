Feature: Test Login Functionality
    

Scenario: A user wants to login
    Given a user is on login page
    When a user enters the correct username and correct password
    When clicks on login button
    Then a user is navigated to dashboard page

