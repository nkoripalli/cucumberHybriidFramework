@all 
Feature: Search functionality
User is running a search for a desired product

Background: 
Given User open the application

@search @validproduct @regression @smoke
Scenario: Search for valid product
When User enter the product into Search field
And User click on Search button
Then Valid product should get displyed in serach results 

@search @non-existingproduct @regression @smoke
Scenario: Search for non-existing product
When User enter invalid product into Search field
And User click on Search button
Then Proper text indicating user about no matching product shoudl be displayed

@search @non-existingproduct @smoke
Scenario: Search without providing a product
When User do not enter any product into Search field
And User click on Search button
Then Proper text indicating user about no matching product shoudl be displayed 