Feature: Post Update Sections

  @Section @PositiveCase
  Scenario Outline: Post update section with valid json
    Given Post update section with valid id <id>
    When  Send request post update section
    Then  Status code should be 200 OK
    And   Validate Put update section with valid parameter json schema validator
    Examples:
      | id        |
      | 128418736 |

  @Section @NegativeCase
  Scenario Outline: Post update section with invalid json
    Given Put update section with invalid id <id>
    When  Send request post update section
    Then  Status code should be 404 Not Found
    Examples:
      | id        |
      | 11111111  |

  @Section @NegativeCase
  Scenario Outline: Post create a new project with empty request body
    Given Post create a new project valid id <id> with empty request body
    When  Send request post update section
    Then  Status code should be 400 Bad Request
    Examples:
      | id        |
      | 128247961 |

