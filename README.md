# Lab 01 - R&D Task 04 "ATDD-LLM"
In this task it is required to use LLMs to write, improve, complete, implement, reverse-engineer Gherkin specifications.
I have asked the same questions to each LLM and compared the answers to see which one replied with the most accurate and
complete answer.

The LLMs used in this task are:

- ChatGPT
- Gemini
- Claude
- Perplexity

The questions asked to the models are the following:

Q1:
```text
Gherkin, generate a Gherkin specification for a division operation considering:
- only 2 integers as input
- only integers as output
- use Scenario Outline
```

A follow-up question was asked to the models that did not consider the case of division by zero in their initial 
response:

Q2:
```text
Add a Scenario for the division by zero edge case
```

### ChatGPT (GPT-4o1)

Q1: 
```text
Gherkin, generate a Gherkin specification for a division operation considering:
- only 2 integers as input
- only integers as output
- use Scenario Outline
```

A1:
```gherkin
Feature: Dividing numbers with a Calculator
  In order to avoid doing math by hand
  As someone who struggles with math
  I want to be able to divide integers using a Calculator

  Scenario Outline: Divide two integers
    Given I have a Calculator
    When I divide <arg0> by <arg1>
    Then the quotient should be <res>

    Examples:
      | arg0 | arg1 | res |
      | 6    | 3    | 2   |
      | 7    | 2    | 3   |
      | -8   | 2    | -4  |
      | 10   | -2   | -5  |
      | -9   | -3   | 3   |
```

Since ChatGPT did not consider the case of division by zero, i asked the following question, to which it responded:

Q2:
```text
Add a Scenario for the division by zero edge case
```

A2:
```gherkin
Scenario: Division by zero
  Given I have a Calculator
  When I divide 10 by 0
  Then an error should occur
```

ChatGPT completed the task successfully, suggested many correct examples and also considered negative numbers, but it 
did not consider the case of division by zero at first.

### Gemini (2.0 Flash)

Q1:
```text
Gherkin, generate a Gherkin specification for a division operation considering:
- only 2 integers as input
- only integers as output
- use Scenario Outline
```

A1:
```gherkin
Feature: Integer Division

  As a user,
  I want to divide two integers,
  So that I get the integer quotient.

  Scenario Outline: Divide two integers
    Given I have the integer <dividend>
    And I have the integer <divisor>
    When I perform the division
    Then the result should be the integer <quotient>

    Examples:
      | dividend | divisor | quotient |
      | 10       | 2       | 5        |
      | 15       | 3       | 5        |
      | 7        | 2       | 3        |
      | 0        | 5       | 0        |
      | -10      | 2       | -5       |
      | 10       | -2      | -5       |
      | -10      | -2      | 5        |
      | -7       | 2       | -3       |
      | 7        | -2      | -3       |
```

Since Gemini did not consider the case of division by zero, i asked the follow-up question, to which it responded:

Q2:
```text
Add a Scenario for the division by zero edge case
```

A2:
```gherkin
Scenario: Division by zero
  Given I have the integer 10
  And I have the integer 0
  When I perform the division
  Then an error should be raised indicating division by zero
```

Gemini completed the task successfully, suggested many correct examples (more than ChatGPT) and also considered negative
numbers, but it did not consider the case of division by zero at first.

### Perplexity

Q1:
```text
Gherkin, generate a Gherkin specification for a division operation considering:
- only 2 integers as input
- only integers as output
- use Scenario Outline
```

A1:
```gherkin
Feature: Division Operation
  As a user
  I want to perform division operations with two integers
  So that I can get the correct integer result

  Scenario Outline: Divide two integers
    Given two integers <numerator> and <denominator>
    When I divide <numerator> by <denominator>
    Then the result should be <result>

    Examples:
      | numerator | denominator | result |
      | 10        | 2           | 5      |
      | 7         | 3           | 2      |
      | 15        | 5           | 3      |

  Scenario: Division by zero
    Given two integers 10 and 0
    When I divide 10 by 0
    Then an error should occur
```

Perplexity completed the task successfully, suggested correct examples and also considered the case of division by zero
that both ChatGPT and Gemini missed.

### Claude

Q1:
```text
Gherkin, generate a Gherkin specification for a division operation considering:
- only 2 integers as input
- only integers as output
- use Scenario Outline
```

A1:
```gherkin
Feature: Integer Division Operation
  As a user
  I want to divide two integers
  So that I can get the integer result of division

  Scenario Outline: Divide two integers
    Given I have a first integer <dividend>
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
    Given I have a first integer 10
    And I have a second integer 0
    When I attempt to divide the first integer by the second integer
    Then I should get an error message indicating division by zero is not allowed
```

Claude completed the task successfully, suggested correct examples and also considered the case of division by zero just
like Perplexity. Also, Claude provided more examples than the other models.

## Conclusion
Each model successfully generated a Gherkin specification for a division operation considering the given constraints.
Some required small modifications like the case of division by zero, which was not initially considered by some models.
However, ChatGPT and Gemini initially missed the case of division by zero, which was later corrected.
Perplexity and Claude considered the division by zero case in their initial responses. 
Claude provided more examples than the other models, which is beneficial for testing purposes.
Overall, all models were able to generate the required Gherkin specification effectively and speeded up the process of
writing test cases.

To rank the models based on the completion of the task, consideration of edge cases, and the number of examples provided,
the ranking would be as follows:
1. Claude
2. Perplexity
3. Gemini
4. ChatGPT

This result was unexpected, since Perplexity and Claude are not as well-known as ChatGPT and Gemini, but they performed
better in this specific task.
However, the difference between the models is not significant, and since this was a simple task all models were able to
generate the Gherkin specification effectively.
It is not possible to draw a general conclusion from this single task, but it is interesting to see that less known
models can perform better than well-known models in some simple tasks.
