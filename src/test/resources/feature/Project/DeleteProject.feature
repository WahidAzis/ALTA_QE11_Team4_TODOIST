Feature: Delete Project

  @Delete @PositiveCase
  Scenario Outline: Delete a project with valid id parameter
    Given Delete a project with valid <id> parameter
    When  Send request delete user project
    Then  Status code is 204 No Content
    Examples:
      | id         |
      | 2315988467 |

  @Delete @NegativeCase
  Scenario Outline: Delete a project with unavailable id parameter
    Given Delete a project with unavailable <id> parameter
    When  Send request delete user project
    Then  Status code is 204 No Content
    Examples:
      | id        |
      | 124534774 |

  @Delete @NegativeCase
    #bug
  Scenario Outline: Delete project with invalid id parameter
    Given Delete project with invalid <id> parameter
    When  Send request delete user project
    Then  Status code should be 400 Bad Request
    Examples:
      | id        |
      | 127@#D    |