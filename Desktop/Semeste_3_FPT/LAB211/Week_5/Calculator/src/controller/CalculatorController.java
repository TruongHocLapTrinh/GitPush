package controller;

import Util.ValidationUtil;
import model.BMICalculator;
import model.NormalCalculator;
import view.HomeView;

public class CalculatorController {

    private HomeView homeView;
    private NormalCalculator normalCalculator;

    public CalculatorController() {
        this.homeView = new HomeView(this);
        this.normalCalculator = new NormalCalculator();
    }

    public void start() {
        homeView.show();
    }

    public NormalCalculator.Operator getValidOperator() {
        NormalCalculator.Operator operator = null;

        do {
            String operatorInput = ValidationUtil.inputWithOutEmpty("Enter Operator");
            try {
                operator = normalCalculator.checkOperator(operatorInput);
                if (operator == null) {
                    System.out.println("Please input (+, -, *, /, ^)");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operator. Please try again.");
            }
        } while (operator == null);

        return operator;
    }

    public double calculateResult(double a, NormalCalculator.Operator operator, double b) {
        return normalCalculator.calculate(a, operator, b);
    }

    public double calculateBMI(double weight, double height) {
        return new BMICalculator().calculateBMI(weight, height);
    }

    public BMICalculator.Status calculateBMIStatus(double bmi) {
        return BMICalculator.calculateBMIStatus(bmi);
    }
}