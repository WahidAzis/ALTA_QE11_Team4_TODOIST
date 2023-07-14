Feature: Delete Task

  @Delete @PositiveCase
  Scenario Outline: Delete a task with valid id parameter
    Given Delete a task with valid <id> parameter
    When  Send request delete task
    Then  Status code is 204 No Content
          Examples:
            | id         |
            | 7047335233 |


  @Delete @NegativeCase
  Scenario Outline: Delete a task with invalid id parameter special char
    Given Delete a task with invalid id <id> parameter special char
    When  Send request delete task
    Then  Status code is 204 No Content
    Examples:
      | id         |
      | @@$@       |


  @Delete @NegativeCase
  Scenario Outline: Delete a task with unavailable
    Given Delete a task with unavailable <id>
    When  Send request delete task
    Then  Status code is 204 No Content
    Examples:
      | id        |
      | 124534774 |