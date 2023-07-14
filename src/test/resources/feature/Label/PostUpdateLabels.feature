Feature: Post Update Labels

  @Labels @PositiveCase
  Scenario Outline:Update a personal label with valid id and request body
    Given Post update a personal with valid id <id> and request body
    When  Send POST request for update a labels
    Then  Status code should be 200 OK
    And   Validate post update labels with valid parameter id json schema validator
    Examples:
      | id         |
      | 2167687463 |

  @Labels  @NegativeCase
  Scenario Outline:Update a personal label with invalid id and valid request body
    Given Post update a personal label with invalid <id> and valid request body
    When  Send POST request for update a labels
    Then  Status code should be 404 Not Found
    Examples:
      | id         |
      | 99977788   |

  @Labels  @NegativeCase
  Scenario Outline:Update a personal label with valid id and empty body request name
    Given Update a personal label with valid <id> and empty body request name
    When  Send POST request for update a labels
    Then  Status code should be 400 Bad Request
    Examples:
      | id         |
      | 99977788   |

  @Labels  @NegativeCase
  Scenario Outline:Update a personal label with valid id and without body request
    Given Update a personal label with valid id <id> and without body request
    When  Send POST request for update a labels
    Then  Status code should be 400 Bad Request
    Examples:
      | id       |
      | 99977788 |

  @Labels  @NegativeCase
  Scenario Outline:Update a personal label empty
    Given Update a personal label <id> empty
    When  Send POST request for update a labels
    Then  Status code should be 400 Bad Request
    Examples:
      | id |
      |    |
