Feature: Post Update Comments

  @Comments @PositiveCase
  Scenario Outline: Post update a comment with valid id and content
    Given Post update a comment with valid <id> and content
    When  Send request post update comments
    Then  Status code should be 200 OK
    And   Validate post update comments with valid parameter page json schema validator
    Examples:
      | id        |
      | 3316943302 |


  @Comments @NegativeCase
  Scenario Outline: Post update a comment with invalid id  and valid content
    Given Post update a comment with invalid <id> and valid content
    When  Send request post update comments
    Then  Status code should be 404 Not Found

    Examples:
      | id          |
      | 12335346573 |

  @Comments @NegativeCase
    #BUG 404
  Scenario Outline: Post update a project with valid id and empty name
    Given Post update a comments with valid <id> and empty name
    When  Send request post update comments
    Then  Status code is 204 No Content
    Examples:
      | id          |
      | 3313966391 |

  @Comments @NegativeCase
    #BUG 404
  Scenario Outline: Post update a project with valid id and number data type of name
    Given Post update a comments with valid <id> and number data type of name
    When  Send request post update comments
    Then  Status code should be 200 OK
    Examples:
      | id          |
      | 3316943302  |
