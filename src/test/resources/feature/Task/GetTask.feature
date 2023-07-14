Feature: Get Tasks

  @Tasks @PositiveCase
  Scenario Outline:Get an active task with valid id parameter
    Given Get an active task with valid <id> parameter
    When  Send GET request for get an active task
    Then  Status code should be 200 OK
    And   Validate Get tasks with valid parameter id json schema validator
    Examples:
      | id           |
      | "7045989679" |


  @Tasks @NegativeCase
    #BUG TODOIST 404
  Scenario Outline: Get an active task with invalid id parameter type special char
    Given Get an active task with invalid id parameter type special <character>
    When  Send GET request for get an active task with special character
    Then  Status code should be 400 Bad Request
    Examples:
      | character |
      | !#@      |


  @Tasks @NegativeCase
    #BUG TODOIST 404
  Scenario Outline: Get an active task with invalid id (unavailable)
    Given Get an active task with invalid parameter <id>
    When  Send GET request for get an active task with invalid id
    Then  Status code should be 404 Not Found
    Examples:
      | id         |
      | 1234567796 |


#  @Tasks @PositiveCase
#  Scenario:Get all active task with available id
#    Given Get all active task with available id
#    When  Send GET request for get an active task available id
#    Then  Status code should be 200 OK