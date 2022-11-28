@gui
Feature: Basic user registration flow
  As a potential user
  I want to be able to register
  In order to be able to log in
  I need to activate my account

#  Scenario: Should register then activate my account and log in
#    Given A new user can be registered with email mirusqua@gmail.com
#    Then A new user has REGISTERED status
#    When A user can be activated
#    Then A user can log in
#    Then Close the browser

  Scenario: User is allowed to log in with valid credentials
    Given user navigates to login page
    When user accepts GDPR prompt
    Then user provides credentials username 'erdodi' and password '50715071niam'
    Then user navigates to incoming mail 'https://mail.centrum.sk'