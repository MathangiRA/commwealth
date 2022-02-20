@AllTests
Feature: View, Add, update delete in Leaderboard


  @Leaderboard
  Scenario Outline: Add a new user in covid game leaderboard
    Given add "<username>" <score> with leaderboard API
    When retrieve all users
    Then verify user is added successfully

    Examples:
      | username   | score     |
      | usr        | 100       |


  @Leaderboard
  Scenario Outline: Update an existing User
    Given add "<username>" 0 with leaderboard API
    When update <score> for the user
    Then verify user is updated successfully

    Examples:
      | username    | score   |
      | usr         | 200     |

    @skip
      #Need valid delete key to run this test
  Scenario Outline: Delete an existing User
    Given add "<username>" 0 with leaderboard API
    When delete the user
    Then verify user is deleted successfully

    Examples:
      | username   |
      | usr        |
