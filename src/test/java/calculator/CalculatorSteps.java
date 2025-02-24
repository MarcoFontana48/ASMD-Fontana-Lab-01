package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorSteps {
    private int res = 0;
    private Calculator calculator;
    
    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }
    
    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }
    
    @Then("the sum should be {int}")
    public void theSumShouldBe(int arg0) {
        this.calculator.add();
        if (arg0 != this.calculator.getResult()) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }
    
    @When("I multiply {int} and {int}")
    public void iMultiplyArgAndArg(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }
    
    @Then("the product should be {int}")
    public void theProductShouldBeRes(int arg0) {
        this.calculator.multiply();
        if (arg0 != this.calculator.getResult()) {
            throw new IllegalStateException();
        }
    }
    
    @When("I subtract {int} and {int}")
    public void iSubtractArgAndArg(int arg0, int arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }
    
    @Then("the difference should be {int}")
    public void theDifferenceShouldBeRes(int arg0) {
        this.calculator.subtract();
        if (arg0 != this.calculator.getResult()) {
            throw new IllegalStateException();
        }
    }
    
    @And("I have a first integer {int}")
    public void iHaveAFirstIntegerDividend(int arg0) {
        this.calculator.enter(arg0);
    }
    
    @And("I have a second integer {int}")
    public void iHaveASecondIntegerDivisor(int arg1) {
        this.calculator.enter(arg1);
    }
    
    @When("I divide the first integer by the second integer")
    public void iDivideTheFirstIntegerByTheSecondInteger() {
        this.calculator.divide();
    }
    
    @Then("I should get the integer result {int}")
    public void iShouldGetTheIntegerResultResult(int res) {
        if (res != this.calculator.getResult()) {
            throw new IllegalStateException();
        }
    }
    
    @When("I attempt to divide the first integer by the second integer")
    public void iAttemptToDivideTheFirstIntegerByTheSecondInteger() {
        try {
            this.calculator.divide();
        } catch (ArithmeticException e) {
            // expected
        }
    }
    
    @Then("I should get an error message indicating division by zero is not allowed")
    public void iShouldGetAnErrorMessageIndicatingDivisionByZeroIsNotAllowed() {
        assertThrows(ArithmeticException.class, () -> this.calculator.divide());
    }
}