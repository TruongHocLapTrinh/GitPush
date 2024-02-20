package view;

import Util.ValidationUtil;
import controller.CalculatorController;
import java.util.Scanner;
import model.BMICalculator;
import model.NormalCalculator;

public class HomeView {

    private CalculatorController calculatorController;

    public HomeView(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Normal Calculator", "BMI Calculator", "Exit"};
        Menu<String> homeMenu = new Menu<>("Calculator Program ", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        performNormalCalculator();
                        break;
                    case 2:
                        performBMICalculator();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        };
        homeMenu.run();
    }

    private void performNormalCalculator() {
        double currentResult = ValidationUtil.inputForParseDouble("Enter the first number");

        while (true) {
            NormalCalculator.Operator operator = calculatorController.getValidOperator();
            if (operator == NormalCalculator.Operator.EQUALS) {
                break;
            }

            double operand = ValidationUtil.inputForParseDouble("Enter the next number");
            currentResult = calculatorController.calculateResult(currentResult, operator, operand);
            displayResult(currentResult);
        }

        System.out.println("Result: " + currentResult);
    }

    private void performBMICalculator() {
        try {
            double weight = ValidationUtil.inputForParseDouble("Enter Weight(kg)");
            double height = ValidationUtil.inputForParseDouble("Enter Height(cm)");

            double bmi = calculatorController.calculateBMI(weight, height);
            BMICalculator.Status bmiStatus = calculatorController.calculateBMIStatus(bmi);

            displayBMIResult(bmi, bmiStatus);
        } catch (NumberFormatException | NullPointerException e) {
            displayErrorMessage("Invalid input. Please enter valid numeric values.");
        }
    }

    private void displayResult(double result) {
        System.out.println("Memory: " + result);
    }

    private void displayBMIResult(double bmi, BMICalculator.Status bmiStatus) {
        System.out.println("BMI: " + bmi);
        System.out.println("BMI Status: " + bmiStatus);
    }

    private void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}