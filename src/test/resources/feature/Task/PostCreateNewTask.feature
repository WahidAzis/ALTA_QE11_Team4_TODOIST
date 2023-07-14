Feature: Post Create New Task

  @@Tasks @PositiveCase
  Scenario:Post Create a new task with valid request body
    Given Post Create a new task with valid request body
    When  Send POST request for create a new task
    Then  Status code should be 200 OK
    And   Validate post tasks with valid parameter id json schema validator

  @Tasks @NegativeCase
  Scenario:Post Create a new task empty request body
    Given Post Create a new task empty request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

  @Tasks @NegativeCase
    #BUG ON TODOIST
  Scenario:Post Create a new task with invalid content request body
    Given Post Create a new task with invalid content request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

  @Tasks @NegativeCase
      #BUG ON TODOIST
  Scenario:Post Create a new task with invalid content request body
    Given Post Create a new task with invalid content request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

  @Tasks @NegativeCase
  Scenario:Post Create a new task with empty content request body
    Given Post Create a new task with empty content request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

  @Tasks @NegativeCase
  Scenario:Post Create a new task with invalid due_string request body
    Given Post Create a new task with invalid due_string request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

  @Tasks @NegativeCase
  Scenario:Post Create a new task with empty due_string request body
    Given Post Create a new task with empty due_string request body
    When  Send POST request for create a new task
    Then  Status code should be 400 Bad Request

