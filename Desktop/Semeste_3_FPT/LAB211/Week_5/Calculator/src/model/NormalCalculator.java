package model;

public class NormalCalculator {

    public enum Operator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EXPONENT, EQUALS
    }

    public Operator checkOperator(String operator) {
        switch (operator) {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "*":
                return Operator.MULTIPLICATION;
            case "/":
                return Operator.DIVISION;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUALS;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            case EXPONENT:
                return Math.pow(a, b);
            case EQUALS:
                return a;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}