Feature: Login into application

Scenario Outline: Positive login validation

Given Initialize the browser with chrome
And Navigate to the "http://qaclickacademy.com" site
And Click on login link on home page to land on secure login page
When User enters <username> and <password> and logs in
Then Verify User is successfuly logged in
And Close Browsers

Examples:
|username 		   |password     	|
|test99@gmail.com  |123456			|
|test123@gmail.com |123456			|
