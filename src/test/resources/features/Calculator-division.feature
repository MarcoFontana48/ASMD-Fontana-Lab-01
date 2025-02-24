Feature: Integer Division Operation
  As a user
  I want to divide two integers
  So that I can get the integer result of division

  Background:
    Given I have a Calculator

  Scenario Outline: Divide two integers
    And I have a first integer <dividend>
    And I have a second integer <divisor>
    When I divide the first integer by the second integer
    Then I should get the integer result <result>

    Examples:
      | dividend | divisor | result |
      | 10       | 2       | 5      |
      | 7        | 2       | 3      |
      | 20       | 5       | 4      |
      | 100      | 10      | 10     |
      | -10      | 5       | -2     |
      | 10       | -5      | -2     |
      | -10      | -5      | 2      |
      | 0        | 5       | 0      |

  Scenario: Division by zero
    And I have a first integer 10
    And I have a second integer 0
    When I attempt to divide the first integer by the second integer
    Then I should get an error message indicating division by zero is not allowed
