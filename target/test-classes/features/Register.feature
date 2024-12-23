@all
Feature: User Registartion
User is attempting to Register to Login to the application

Background: 
Given User navigate to Register Account page

@Register @smoke
Scenario: Register with mandatroy fields
When User enters below data into the fields
|firstname			|Suresh	|
|lastname				|M    	|
|telephone		  |123145	|
|password				|34515	|
|confirmPassword|34515|
And Select Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@Register @regression
Scenario: Register with all fields
When User enters below data into the fields
|firstname			|Naveen|
|lastname				|K|
|telephone		  |12345|
|password				|3455|
And Selects Yes for Newsletter
And Select Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@Register @regression @withourfields 
Scenario: Register without providing any fields
When User dont enter data in any fields
And Clicks on Continue button
Then Warning message should dispaly for all mandatory fields

@Register @smoke @withourfields 
Scenario: Register with duplicate email Address
When User enters below data into the fields with duplicate email
|firstname			|Satish|
|lastname				|M|
|email address  |test@gmail.com|
|telephone		  |123345|
|password				|34355|
And Select Privacy Policy field
And Clicks on Continue button
Then Warning message should display indicating duplicate email address