Feature: Login info Application

Scenario Outline: Positive test validation login
Given Initialise the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login link in the homepage to land on sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And Close browser

Examples:
|username				|password		|
|test99@gmail.com 		|123456			|
|test34@gmail.com		|654321			|