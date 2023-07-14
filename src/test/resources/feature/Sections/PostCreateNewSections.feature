Feature: Post Create New Sections

  @Section @PositiveCase
  Scenario:
    Given Post create new section with valid parameter
    When  Send request post create new section
    Then  Status code should be 200 OK
    And   Validate Get all section with valid parameter json schema validator"


  @Section @NegativeCase
  Scenario: Post create new invalid section with empty project
    Given Post create new invalid section with empty project
    When  Send request post create new section
    Then  Status code should be 400 Bad Request

  @Section @NegativeCase
  Scenario: Post create new invalid section with empty name
    Given Post create new invalid section with empty name
    When  Send request post create new section
    Then  Status code should be 400 Bad Request

  @Section @NegativeCase
  Scenario: Post create new invalid section special char
    Given Post create new invalid section with special char
    When  Send request post create new section
    Then  Status code should be 400 Bad Request
