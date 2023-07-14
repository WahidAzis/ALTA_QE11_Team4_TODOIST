Feature: Post Update Project

  @Project @PositiveCase

  Scenario Outline: Post update project with valid json
    Given Post update project with valid <id>
    When  Send request post update project
    Then  Status code should be 200 OK
    And   Validate post update project with valid parameter id json schema validator
    Examples:
      | id         |
      | 2315988467 |

  @Project  @NegativeCase
  Scenario Outline: Post update a project with valid id parameter and empty request body
    Given Post update a project with valid <id> parameter and empty request body
    When  Send request post update section
    Then  Status code should be 404 Not Found
    Examples:
      | id          |
      | 12335346573 |

  @Project  @NegativeCase
  Scenario Outline: Post update a project with valid id parameter and empty name
    Given Post update a project with valid <id> parameter and empty name
    When  Send request post update section
    Then  Status code should be 400 Bad Request
    Examples:
      | id          |
      | 2315988467  |


  @Project  @NegativeCase
  Scenario Outline: Post update a project with valid id parameter and invalid name
    Given Post update a project with valid <id> parameter and invalid name
    When  Send request post update section
    Then  Status code should be 400 Bad Request
    Examples:
      | id          |
      | 2315988467  |

