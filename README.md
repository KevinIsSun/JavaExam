# Introduction

1. clone the repo.
2. run `gradle bootRun` to start the application
3. open http://localhost:8080/ in your browser. If you can see "Hello,trump", it works great.

# Requirement
1. Implement registration and login functions. Please use the existing UserController to implement a UI page for user to
register and login. When user registers, they need provide their username, email address and password. Once the user has
login, please use cookie to keep the user login status, and it will expire after half an hour.
2. Complete the unit test for the functions implemented in the first step, including tests for the controller and
service, etc. Try your best to increase code coverage.
3. Fix bugs in BugController. Make sure we can see `Success` when open `http://localhost:8080/show_bug` page.
4. After you completed, please send a pull request to origin repo.

