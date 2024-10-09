Feature: LoginTest

Scenario: Login Successfully
				Given the user is on the login page
				When the user enter valid username and valid password
				And click the login button
				Then the user should be loggin successfully
				And should be redirected to the dashboard

				
Scenario: Invalid Login
				Given the user is on the login page
				When the user enter invalid username and invalid password
				And click the login button
				Then the user should be see error message
				And should not be login