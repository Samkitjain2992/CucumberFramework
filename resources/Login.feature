Feature: Login

  Scenario : Successful login with registered credentials
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain2992@gmail.com"
    And    Password as "samkitjain"
    And Click on login button
    And Page Title should be "My account - My Store"
    And User click log out link
    And close browser


  Scenario: Verify error message for unregistered credential
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain212@gmail.com"
    And  Password as "samjkk"
    And Click on login button
    And Error message for unregistered credential is "Authentication failed."
    And close browser


  Scenario: Verify field validation for login
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    And User enters Email as "12345abc"
    And Click on login button
    And Error message for invalid email id is "Invalid email address."
    And Clear email field
    And User enters Email as "12345abc@"
    And Click on login button
    And Error message for invalid email id is "Invalid email address."
    And Clear email field
    And User enters Email as "12345abc@.com"
    And Click on login button
    And Error message for invalid email id is "Invalid email address."
    And Clear email field
    And User enters Email as "12345abc@@.com"
    And Click on login button
    And Error message for invalid email id is "Invalid email address."
    And Clear email field
    And User enters Email as "12345abc@gmail"
    And Click on login button
    And Error message for invalid email id is "Invalid email address."
    And Clear email field

  Scenario: Verify error message for wrong password
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain2992@gmail.com"
    And    Password as "samkitjj"
    And Click on login button
    And Error message for wrong password is "Authentication failed."
    And close browser

  #Scenario: Add a new Customer
   # Given Open Application as "http://automationpractice.com/index.php"
   # And User click sign in button
    #When User enter emailId as "samkitjain@cddnsol.com"
   # And Click on create an account
   # Then User can view create an account page
   # When User enter
    #Then Click register button
    #When User enter Customer info
    #And Click on save button
    #Then User can view confirmation message "The new customer has been added successfully."
   # And close browser


