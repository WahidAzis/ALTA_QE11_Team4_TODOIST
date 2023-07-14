Feature: Get Labels

  @Labels @PositiveCase
  Scenario Outline:Get a all personal label with valid id parameter
    Given Get a all personal label with valid <id> parameter
    When  Send GET request for get a personal label
    Then  Status code should be 200 OK
    And   Validate Get labels with valid parameter id json schema validator
    Examples:
      | id           |
      | "2167687845" |


  @Labels @PositiveCase
  Scenario Outline:Get a personal label with valid id parameter
    Given Get an personal label with valid parameter <id>
    When  Send GET request for get a personal label
    Then  Status code should be 200 OK
    And   Validate Get labels with valid parameter id json schema validator
    Examples:
      | id           |
      | "2167642334" |

  @Labels @NegativeCase
  Scenario Outline:Get a personal label with invalid id parameter
    Given Get a personal label with invalid <id> parameter
    When  Send GET request for get a personal label
    Then  Status code should be 404 Not Found
    Examples:
      | id    |
      | "&%@" |


  @Labels @NegativeCase
  Scenario Outline:Get a personal label with invalid id
    Given Get a personal label with invalid id <id>
    When  Send GET request for get a personal label
    Then  Status code should be 404 Not Found
    Examples:
      | id        |
      | "9997899" |

  @Labels @NegativeCase
    #BUG TODOIST SHOULD BE 400 BAD REQUEST
  Scenario Outline:Get a personal label with key label name
    Given Get a personal label with key label name <id>
    When  Send GET request for get a personal label
    Then  Status code should be 404 Not Found
    Examples:
      | id        |
      | "9997899" |
