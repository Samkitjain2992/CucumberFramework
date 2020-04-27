Feature: Login Page
  
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
    And Password as "samjkk"
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
    Then close browser

  Scenario: Verify error message for wrong password
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain2992@gmail.com"
    And Password as "samkitjj"
    And Click on login button
    And Error message for wrong password is "Authentication failed."
    And close browser

  Scenario: Verify the Functionality of reset password whit invalid email address
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain212@gmail.com"
    And User click forgot password button
    And User enter invalid email as "samkitjaineiri.com"
    And Click retrieve password
    And Error message for invalid email id is "Invalid email address."
    Then close browser

  Scenario: Verify functionality of forgot password link
    Given Open Application as "http://automationpractice.com/index.php"
    And User verify page title"My Store"
    And User click sign in button
    When User enters Email as "samkitjain212@gmail.com"
    And User click forgot password button
    And User enter Valid email as "samkitjain2992@gmail.com"
    And Click retrieve password
    And Confirmation message for forgot password as"A confirmation email has been sent to your address: samkitjain2992@gmail.com"
    And Click back to login button
    And User verify page title"Login - My Store"
    Then close browser
