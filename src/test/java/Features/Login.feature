Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
  Given default properties loded into hashmap
  And set login username to "somesh"
  And set login password to "kumud"
  When user perform login action
  Then user should see message ""





 #   Given I navigate to the login page
 #   And I enter the following for Login
 #     | username | password |
 #     | om       | om       |
 #   And I click login button
 #   Then I should see the userform page
