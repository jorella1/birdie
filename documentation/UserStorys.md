5 different features per User:

    - Register/Login/Logout
    - Post Birdie
    - View Birdies
    - Like Birdies
    - Comment on Birdies
    - Search Birdies
Admin:

    - Delete Birdies
    - Add warning to Birdie?
    - Delete comment
    - Ban user
    - (Fifth needed?)

### As a new user to Birdie, I want to register an account, so I can login.

    - Welcome Page with registration/login buttons
    - Routing to registration page
    - AWS setup with user db
    - input validation with unit testing
    - Routing to login page after submission
    - Login page
    - Login validation and routing to profile
    - Profile page

### As a returning user to Birdie, I want to login, to post a birdie.

    - Profile page options
    - Post birdie interface
    - setup birdie db
    - insert methods for birdie db
    - select methods for birdie db
    - determine routing post submission (all birdies or just yours)


### As a normal user to Birdie, I want to view other birdies, so I can interact and like others birdies.

    - retrieve all birdies methods
    - view other birdies page (different from profile page)
    - setup comment/like db
    - insert/select methods for comment/like db
    - interface for commenting/liking birdies

### As an admin user to Birdie, I want to view other birdies, so I can moderate them

    - admin profile options
    - ban user option
        - remove comments/likes from comment db
        - remove birdies from birdies db
        - keep user in user db
        - warning for next login by user
    - admin db? with record of who ban/deleted what?
    - interface to remove or alter birdies/comments
    - remove methods for birdie and comment/like db

