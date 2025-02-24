Feature:  Multiplying numbers with a Calculator
  In order not to learn math
  As someone who is bad at math
  I want to be able to multiply numbers using a Calculator

  Scenario Outline: Multiply two numbers
    Given I have a Calculator
    When I multiply <arg0> and <arg1>
    Then the product should be <res>
    Examples:
      | arg0 | arg1 | res |
      | 1    | 1    | 1   |
      | 1    | -1   | -1  |
      | -5   | -6   | 30  |
      | 0    | 1    | 0   |
      | 0    | 0    | 0   |
      | 1    | 0    | 0   |