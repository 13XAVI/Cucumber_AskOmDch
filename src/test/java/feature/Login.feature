Feature: User Login
  As a registered user
  I want to login to my account
  So that I can access my account features

  Background:
    Given I am on the AskOmDch Account page

  Scenario Outline: Login with valid credentials
    When I login with username "<username>" and password "<password>"
    Then I should be logged in successfully
    And I should see "<welcomeText>" and "<logoutText>"

    Examples:
      | username  | password  | welcomeText        | logoutText |
      | TestUser  | Test@123  | Hello testuser | Log out     |

  Scenario Outline: Login with multiple invalid credentials
    When I attempt to login with username "<username>" and password "<password>"
    Then I should see the login error message "<errormessage>"

    Examples:
      | username     | password      | errormessage                                           |
      | invalidUser  | Test@123      | Error: The username you entered is not registered.     |
      | TestUser     | wrongPassword | Error: The password you entered is incorrect.          |
      |              | Test@123      | Error: Please enter a valid account username.          |
      | TestUser     |              | Error: The password field is empty.                     |
      |              |              | Error: Username is required.                            |