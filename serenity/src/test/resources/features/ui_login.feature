@gui
Feature: GUI - Login mechanism

  As a OEBB user
  I want to be able to log on or log off the GUI
  So that I can access the vouchers

  Scenario: User can log in Voucher GUI with valid credentials
    Given user is on login page
    When user provides valid credentials as 'ADMIN_USER'
    And user click LOG IN button
    Then user can see transactions page

  Scenario: User can log in Voucher GUI with valid credentials and pressing ENTER
    Given user is on login page
    When user provides valid credentials as 'ADMIN_USER'
    And user press enter key on login page
    Then user can see transactions page

  Scenario: User is not allowed to log in Voucher GUI with invalid password
    Given user is on login page
    When user provides credentials user 'user' and password 'invalid'
    Then user click LOG IN button and check error message

  Scenario: User is not allowed to log in Voucher GUI with invalid username
    Given user is on login page
    When user provides credentials user 'invalid' and password 'password'
    Then user click LOG IN button and check error message