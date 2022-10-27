Feature: Login Feature
  Verify login feature with correct credentials
  
Background:
Given User open salesforce application
When user is on "LoginPage"

 

@regression
  Scenario: Login error message for empty password
		
		When user enter value of username "" and emptypassword ""
    When user click on login button
    Then Verify the error message ""
    
 @regression 
   Scenario: Login with correct  correct username and correct password
  
    When user enter value of validUsername "" and validPassword ""
    When user click on login button
    When user is on "HomePage"
    Then Verify page title ""
    
   @regression 
    Scenario: Check remember me button
    
    When user enter value of username "" and password ""
    When user click remember check box
    When user click on login button
    When user is on "HomePage"
    Then click on the username
    Then click on logout button from user drop down menu
    When user is on "LoginPage"
    Then Validate username field as ""
    
  @regression  
    Scenario: forgot password
    
    When user click on forgot password button
    When user is on "ForgotPasswordPage"
    Then enter username as ""
    Then click on continue button
    When user is on "ForgotPasswordPage"
    Then verify the message sent in email as ""
    
    @regression
    Scenario: invalid credentials
    
    When user enter value of invalidusername "" and invalidpassword ""
    When user click on login button
    Then error message should be displayed ""