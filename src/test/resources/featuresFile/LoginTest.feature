Feature: LoginTest

Background: user is on login page
					Given the user is on the login page

@smokeTest
Scenario: Login Successfully
				When the user enter valid username and valid password
				And click the login button
				Then the user should be loggin successfully
				And should be redirected to the dashboard

				
Scenario: Invalid Login
				When the user enter invalid username and invalid password
				And click the login button
				Then the user should be see error message
				And should not be login
				
				
Scenario: Login Steps for Successful Login
				When the user enter "Admin" and "admin123"
				And click the login button
				And should be redirected to the dashboard
				
@smokeTest	
Scenario Outline: Login Steps for Successful Login
				When the user enter "<userName>" and "<password>"
				And click the login button
				And should be redirected to the dashboard			
				
				Examples:
				|userName  |password|
				|Admin				  |admin123|
				|admin123  |dd123       |