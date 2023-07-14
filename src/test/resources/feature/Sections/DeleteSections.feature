Feature: Delete Sections

  @Delete @PositiveCase
  Scenario Outline: Delete sections with valid parameter id
    Given Delete section with valid id <id>
    When  Send request delete user
    Then  Status code is 204 No Content
    Examples:
      | id        |
      | 128245089 |