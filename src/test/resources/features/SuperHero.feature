@AllTests
Feature: User Creation, Complete challenge and leaderboard lookup

  Background:
    Given user is on home page

  @CreateUser
  Scenario Outline: Create a new, complete challenge and lookup leaderboard
    Given user enters his "<username>"
    When taps Create Warrior button
    Then user is created successfully
    And completes challenges
    And verify score for "<username>" in leaderboard is "300"

    Examples:
      | username   |
      | testuser29 |


