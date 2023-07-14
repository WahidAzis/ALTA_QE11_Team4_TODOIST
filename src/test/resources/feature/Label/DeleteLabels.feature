Feature: Delete Labels

  @Delete @PositiveCase
  Scenario Outline: Delete labels with valid parameter id
    Given Delete labels with valid id <id>
    When  Send request delete user labels
    Then  Status code is 204 No Content
    Examples:
      | id         |
      | 2167687463 |