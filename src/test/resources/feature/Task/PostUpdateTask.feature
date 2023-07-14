Feature: Post Update Tasks

  @Tasks @PositiveCase
  Scenario Outline:Post Update task with valid id and request body
    Given Post update a task with valid <id> and request body
    When  Send POST request for update a task
    Then  Status code should be 200 OK
    And   Validate post Update tasks with valid parameter id json schema validator
    Examples:
      | id         |
      | 7047044858 |

  @Tasks @NegativeCase
  Scenario Outline:Post Update a task with valid invalid id and valid request body
    Given Post update a task with invalid <id> and valid request body
    When  Send POST request for update a task
    Then  Status code should be 404 Not Found
    Examples:
      | id         |
      | 123456789  |

  @Tasks @NegativeCase
  Scenario Outline:Post Update a task with valid id and empty body content
    Given Post Update a task with valid id <id> and empty body content
    When  Send POST request for update a task
    Then  Status code should be 404 Not Found
    Examples:
      | id         |
      | 123456789  |

  @Tasks @NegativeCase
  Scenario Outline:Post Update a task with valid id and without request body
    Given Post Update a task with valid id <id> and without request body
    When  Send POST request for update a task
    Then  Status code should be 400 Bad Request
    Examples:
      | id         |
      | 123456789  |



