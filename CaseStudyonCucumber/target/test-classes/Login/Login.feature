Feature: Validate Web Tours

Background:
Given open Browser


@Positivetest
Scenario Outline: test with login data
When enter valid username <name>
And enter valid password <pwd>
And click on LoginButton
Then show "<msg>"
And close Browser

Examples:
|name||pwd||msg|
|kavitha||kavitha||Login Successfully|
|sunil||sunil||Login Successfully|

@NegativeTest
Scenario: test with invalid data
When enter invalid username <name1>
And enter invalid password <pwd1>
And click on loginbutton
Then show msg "<errormsg>"
And close Browser

Examples:
|name1||pwd1||errormsg|
|kavi||kavi1||Enter your userName and password correct|
