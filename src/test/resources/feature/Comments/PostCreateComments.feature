Feature: Post Create New Comments

  @Comments @PositiveCase
  Scenario:
    Given Post create a new comment with valid content and task id
    When  Send request post create new comments
    Then  Status code should be 200 OK
    And   Validate post create comments with valid parameter id json schema validator

  @Comments @NegativeCase
  Scenario:Post create a new comment with empty request body
    Given Post create a new comment with empty request body
    When  Send request post create new comments
    Then  Status code should be 400 Bad Request


