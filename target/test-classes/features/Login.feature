@smoke
Feature: OrangeHRM user Management

  Scenario: Add and Delete User After Login with Valid Credentials
    When User login with username "Admin" and password "admin123"
    And User Click to Admin Button and Navigate to Admin Section
    And User get the current number of records found in the Admin Section
    And User add a new user with username "TestUser223" and password "test123" and confirm password "test123"
    Then User Verify that the number of records increased by one after adding the user
    When User search for the user "TestUser223"
    And User delete the user
    And User Reset the search to get all records list
    Then User Verify that the number of records decreased by one after deleting the user
