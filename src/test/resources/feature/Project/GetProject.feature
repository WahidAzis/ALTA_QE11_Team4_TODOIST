Feature: Get Project

  @Project @PositiveCase
  Scenario:Get project with valid id
    Given Get project with valid id "2315988467"
    When  Send get project request
    Then  Status code should be 200 OK
    And   Validate Get project with valid parameter id json schema validator


  @Project @NegativeCase
  Scenario Outline:Get a project with unavailable parameter id
    Given Get a project with unavailable parameter id <id>
    When  Send get project request
    Then  Status code should be 404 Not Found
    Examples:
      | id         |
      | 1234567796 |

  @Project @NegativeCase
  Scenario Outline:Get a project with invalid id special character
    Given Get a project with invalid id special character <character>
    When  Send get project request with invalid id special character
    Then  Status code should be 400 Bad Request
    Examples:
      | character |
      | @@@       |

  @Project @NegativeCase
  Scenario:Get all project with valid id parameter
    Given Get all project with valid id parameter
    When  send get request for get a project
    Then  Status code should be 200 OK
