# Project Description
Our project is essentially a clone of Twitter. Key features of our web app will include: Login and register as a new user, Creating Tweets, viewing a timeline of tweets, creating a user profile and viewing other profiles, liking and viewing other tweets from other users, creating threads from replying to a tweet, Hashtags allow for grouping of posts.

# Test Strategy
## Scope

    - We are anticipating that this document will be reviewed by our supervisors and peers at Revature.
    - Document will ultimately receive approval from our manager.
    - Roughly, we will use the first 1~1.5 weeks to implement the key features of our web app. Essentially creating the “Full Stack” part of our project
    - We will use different test methods and libraries, and do so over the course of the last 3-7 days of the allotted time for the project.

## Test Approach

    - Testing will generally follow the process of programming test pipelines, running tests, and then debugging the tests themselves.
    - We will follow SDLC and STLC. We will use sprints as a way of tracking progress.
    - As for testing levels, we will cover BDD and E2E for more macroscopic tests, and Unit testing for more microscopic tests.
    - Testing will mainly cover minor security and major behavior.
    - Tools used will be Selenium, Behave, and Postman
    - Regressions, new defects, re-testing, and defect triage will all be handled on the fly as we work.
    - We will be using the Ping Pong method of pair programming.

## Test Environment/Testing Tools

    - Database was hosted via AWS RDS and source code was frequently pushed to Github, so we weren't concerned with backups and downtime.
    - Requirements included Java 8+, and from PyPi: selenium, behave, pytest, flask, hashlib, psycopg2, and their dependencies in our java virtual environment. We also needed Postman.

## Release Control

    - We continuously pushed new versions and factorizations of our code to Github

## Risk Analysis

    - SQL Injections
        - use psycopg as a countermeasure
    - Unauthorized access to API
        - implement custom decorators to wrap routings and redirect unauthorized requests. We do this by checking auth tokens on every request and account status.
    - Input validation
        - check well-formedness of inputs using regex
