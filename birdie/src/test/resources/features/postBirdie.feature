Feature: Test Post Birdie Functionality

Background: 
Given a user is on dashboard page

Scenario: A user wants to post a birdie
When a user writes a post
When a user clicks on post button
Then the post is displayed below

Scenario: A user wants to search a birdie
When a user enters text to search
When a user clicks on search button
Then the expected text result page will display

Scenario: A user wants to like a birdie
When a user clicks on like button
Then the post gets likes

Scenario: A user wants to comment on birdie
When a user clicks on comment button
When a user writes a comment
When a user clicks on reply button
Then a comment gets posted

