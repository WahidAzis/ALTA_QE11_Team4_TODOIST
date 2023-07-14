Feature: Get New Sections

  @Section @PositiveCase
  Scenario Outline:Get single section with valid id
  Given Get single section with valid id <id>
  When  Send get single section request
  Then  Status code should be 200 OK
  And   Validate Get single section with valid parameter id json schema validator"
  Examples:
    | id        |
    | 128403285 |

  @Section @NegativeCase
  Scenario Outline: Get single section with invalid id
    Given Get single section with invalid id "<id>"
    When  Send get single section invalid id request
    Then  Status code should be 400 Bad Request
    Examples:
      | id     |
      | 143kel |

  @Section @NegativeCase
  Scenario Outline: Get single section with special character
    Given Get single section with character <character>
    When  Send get single section with special character request
    Then  Status code should be 400 Bad Request
    Examples:
      | character |
      | @@@       |

#/////////////////////////////////////////////////////

  @Section @PositiveCase
  Scenario Outline: Get all sections with valid parameter id
    Given Get all section with valid parameter <id>
    When Send get all section request
    Then Status code should be 200 OK
    Examples:
      | id        |
      | 128403285 |


  @Section @NegativeCase
  Scenario Outline: Get all section with invalid parameter id
    Given Get all section with invalid parameter <id>
    When Send get all section request
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | hehehehehe  |






