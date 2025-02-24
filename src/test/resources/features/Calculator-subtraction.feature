Feature: Subtracting numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to subtract numbers using a Calculator

  Scenario Outline: Subtract two numbers
    Given I have a Calculator
    When I subtract <arg0> and <arg1>
    Then the difference should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 1    | 1    | 0   |
      | 1    | -1   | 2   |
      | -5   | -6   | 1   |
      | 0    | 1    | -1  |
      | 0    | 0    | 0   |
      | 1    | 0    | 1   |