@test
Feature: Basic user registration flow
  As a potential user
  I want to be able to register
  In order to be able to log in
  I need to activate my account

  Scenario: Should register then activate my account and log in
    Given A new user can be registered with email mirusqua@gmail.com
    Then A new user has REGISTERED status
    When A user can be activated
    Then A user can log in