Feature: Get New Comments

  @Comments @PositiveCase
  Scenario Outline:Get all comment with valid id
    Given Get comments with valid id "<id>"
    When  send GET request for get a comment
    Then  Status code should be 200 OK
    And   Validate get new comments with valid parameter page json schema validator
    Examples:
      | id         |
      | 7045989679 |


  @Comments @NegativeCase
  Scenario Outline:Get a comment with unavailable parameter id
    Given Get a comment with unavailable parameter <id>
    When  send GET request for get a comment
    Then  Status code should be 400 Bad Request
    Examples:
      | id         |
      | 1234567796 |

  @Comments @NegativeCase
  Scenario Outline:Get a comment with invalid id
    Given Get a comment with invalid <id>
    When  send GET request for get a comment
    Then  Status code should be 400 Bad Request
    Examples:
      | id         |
      | 12@13      |