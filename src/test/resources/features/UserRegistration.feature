@AllTests
Feature: Add new user to access herokuapp apis

  @RegisterUser
  Scenario Outline: Create a new User
    Given setup "<username>" "<password>" with register API
    When user is registered successfully
    Then new user can login via login API successfully

    Examples:
      | username   | password   |
      | usr        | password   |

  @RegisterUser
  Scenario Outline: Create an existing User
    Given use an existing  "<username>" "<password>"
    When register the user
    Then throws <statuscode>

    Examples:
      | username      | password   | statuscode |
      | usertest01    | password   | 400        |

  @RegisterUser
  Scenario Outline: Use invalid JWT token
    Given setup "<username>" "<password>" with register API with invalid token
    When register the user with "invalidtoken"
    Then throws <statuscode>

    Examples:
      | username      | password   | statuscode |
      | usertest01    | password   | 401        |
