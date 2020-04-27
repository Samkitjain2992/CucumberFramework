Feature: Registration Page

  Background: Common login step
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters create an account EmailAddress filed as"samkitjain12@gmail.com"

  @Smoke
  Scenario: Validate message for all mandatory fields
    Given Registration Page
    And Click on Register button
    When Validate all mandatory message
    Then close browser

  Scenario: validate first name filed on registration page
    Given Registration Page
    When  User enter name as "123"
    And Click on Register button
    Then  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    And  User enter name as "Samkit123"
    When  Click on Register button
    Then  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    And  User enter name as "@Samkit"
    When Click on Register button
    Then  Error message for invalid first name is "firstname is invalid."
    And Clear name filed
    And close browser

  Scenario:  Validate last name filed on registration page
    Given Registration Page
    And  User enter lastname as "123"
    When Click on Register button
    Then Error message for invalid last name is "lastname is invalid."
    And Clear last name filed
    When  User enter lastname as "jain123"
    And Click on Register button
    Then Error message for invalid last name is "lastname is invalid."
    And Clear last name filed
    When  User enter lastname as "@jain123"
    And Click on Register button
    Then Error message for invalid last name is "lastname is invalid."
    And Clear last name filed
    Then close browser


  Scenario: Validate email filed on registration page
    Given Registration Page
    And Email id should display which enter while registration as "samkitjain12@gmail.com"
    And Clear email field on registration page
    When User enter already registered email id as "samkitjain2992@gmail.com"
    And Click on Register button
    Then validation message for already registered user is "An account using this email address has already been registered."
    And Clear email field on registration page
    When User enter invalid email id as "123abc"
    And  Click on Register button
    Then  validation message for invalid email id should be "email is invalid."
    And Clear email field on registration page
    And User enter invalid email id as "abc.com"
    When Click on Register button
    Then  validation message for invalid email id should be "email is invalid."
    And Clear email field on registration page
    And User enter invalid email id as "123abc@gmal"
    When Click on Register button
    Then  validation message for invalid email id should be "email is invalid."
    And close browser

  Scenario Outline: Validate password filed on registration page
    Given Registration Page
    And Information message for password gide line should display is "(Five characters minimum)"
    When enter invalid password as "<invalidPassword>"
    And Click on Register button
    Then Error message for invalid password  should be "<invalidPasswordMessage>"
    And close browser
    Examples:
      | invalidPassword | invalidPasswordMessage |
      | 1234            | passwd is invalid.     |
      | @abc            | passwd is invalid.     |
      | abcd            | passwd is invalid.     |

  Scenario: Validate DOB filed on registration page
    Given Registration Page
    When User give invalid date "30" "2" "2019"
    And Click on Register button
    Then Error message for invalid date "Invalid date of birth"
    When User give DOB as currant date
    And Click on Register button
    Then Error message for  a current date "Invalid date of birth"
    And close browser

  Scenario Outline: Add a new Customer
    Given Registration Page
    When User enter firstName as "<firstName>"
    And User select gender
    And User enter lastName as "<lastName>"
    When User verify emailId as "<emailId>"
    And User enter password as "<password>"
    And User select DOB "12" "2" "1994"
    And User enter address as "<address>"
    And user enter city as "<City>"
    And User select state as "<State>"
    And User enter zip/postal code as "<zipCode>"
    And User enter country as "<Country>"
    And User enter mobilePhone as "<mobilePhone>"
    And Click on Register button
    And Verify user account page title as "My account - My Store"
    Then close browser
    Examples:
      | firstName | lastName | emailId                 | password   | address             | City | State | zipCode | Country | mobilePhone |
      | Samkit    | jain     | samkitjain12@gmail.com | samkitjain | 101,12smkith nakd a | Pune | 2     | 04048   | 21      | 9691777815  |


    


