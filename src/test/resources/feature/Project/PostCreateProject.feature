Feature: Post Create Project


  @Project @PositiveCase
  Scenario:
    Given Post create a new project with valid name
    When  Send request post create new project
    Then  Status code should be 200 OK
    And   Validate Post create a new project with valid parameter json schema validator

  @Project @NegativeCase
  Scenario: Post create a new project with empty request body
    Given Post create a new project with empty request body
    When  Send request post create new project
    Then  Status code should be 400 Bad Request

  @Project @NegativeCase
  Scenario: Post create a new project with empty name
    Given Post create a new project with empty name
    When  Send request post create new project
    Then  Status code should be 400 Bad Request

