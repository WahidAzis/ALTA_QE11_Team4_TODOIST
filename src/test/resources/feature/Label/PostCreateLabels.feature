Feature: Post Create New Labels

  @Labels @PositiveCase
    #Uniq, kalau mau dirun harus ganti body req
  Scenario: Create a new personal label with valid data
    Given Create a new personal label with valid data
    When  Send POST request for a new personal label
    Then  Status code should be 200 OK
    And   Validate post create label with valid parameter id json schema validator

  @Labels @NegativeCase
  Scenario:Create a new personal label with empty body request name
    Given Create a new personal label with empty body request name
    When  Send POST request for a new personal label
    Then  Status code should be 400 Bad Request

  @Labels @NegativeCase
  Scenario:Create a new personal label with invalid parameter special character body request name
    Given Create a new personal label with invalid parameter special character body request name
    When  Send POST request for a new personal label
    Then  Status code should be 400 Bad Request

  @Labels @NegativeCase
  Scenario:Create a new personal label with invalid parameter body request name
    Given Create a new personal label with invalid parameter body request name
    When  Send POST request for a new personal label
    Then  Status code should be 400 Bad Request

  @Labels @NegativeCase
  Scenario:Create a new personal label without body request
    Given Create a new personal label without body request
    When  Send POST request for a new personal label
    Then  Status code should be 400 Bad Request
