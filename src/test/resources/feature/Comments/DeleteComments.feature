Feature: Delete Comments

  @Delete @PositiveCase
  Scenario Outline: Delete a comment with valid
    Given Delete a comment with valid <id>
    When  Send request delete user comments
    Then  Status code is 204 No Content
    Examples:
      | id         |
      | 3313966391 |


  @Delete @NegativeCase
  Scenario Outline: Delete a comment with unavailable id
    Given Delete a comment with unavailable id <id>
    When  Send request delete user comments
    Then  Status code is 204 No Content
    Examples:
      | id        |
      | 124534774 |

  @Delete @NegativeCase
  Scenario Outline: Delete comment with invalid id
    Given Delete comment with invalid id <id>
    When  Send request delete user comments
    Then  Status code is 204 No Content
    Examples:
      | id     |
      | hehehe |