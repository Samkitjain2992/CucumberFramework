Feature: Registration

  Background: Common login step
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters create an account EmailAddress filed as"samkitjain212@gmail.com"

  Scenario: validate first name filed on registration page
    Given Registration Page
    And  User enter name as "123"
    And User click on Register button
    When  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    And  User enter name as "Samkit123"
    And User click on Register button
    When  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    And  User enter name as "@Samkit"
    And User click on Register button
    When  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    Then close browser

  Scenario:  Validate

