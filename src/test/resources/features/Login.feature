Feature: User Login
Registered user should be able to login to access account details

Background: 
Given User navigates to login page

@login @validcredentials @regression   @smoke
Scenario Outline: Login with valid credentials
When User enters valid <email> address
And Enter valid <password> into password field
And Clicks on Login button
Then User should login successfully

Examples: 
|username							|password|
|test@sample.com			|1234|

@login @invalidvalidcredentials @regression
Scenario: Login with Invalid credentials
When User enters invalid email address "naveen.33k@gmail.com"
And Enter invalid password "12345"
And Clicks on Login button
Then User should get a proper warning message 

@login
Scenario: Login with valid email address and invalid password
When User enters valid email address
And Enter invalid password "12345"
And Clicks on Login button
Then User should get a proper warning message

@login
Scenario: Login with invalid email address and valid password
When User enters invalid email address "naveen.33kgmail.com"
And Enter valid password 1234 into password field
And Clicks on Login button
Then User should get a proper warning message
 
@login
Scenario: Login without providing any credentials
When User has not enter any credentials
And Clicks on Login button
Then User should get a proper warning message 