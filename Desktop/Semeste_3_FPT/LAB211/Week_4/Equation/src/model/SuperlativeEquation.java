package model;

import Util.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class SuperlativeEquation extends AbstractEquation {

    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new java.util.ArrayList<>();

        if (a == 0 && b == 0) {
            // Infinitely many solutions
            return solutions;
        } else if (a == 0) {
            // No solution
            return null;
        } else {
            // Single solution
            solutions.add(-b / a);
            return solutions;
        }
    }

    private void checkProperties(float a, float b, List<Float> solutions) {
        List<Float> allNumbers = new ArrayList<>();

        allNumbers.add(a);
        allNumbers.add(b);
        allNumbers.addAll(solutions);

        List<Float> evenNumbers = new ArrayList<>();
        List<Float> oddNumbers = new ArrayList<>();
        List<Float> perfectSquareNumbers = new ArrayList<>();

        for (float number : allNumbers) {
            if (ValidationUtil.isEven(number)) {
                evenNumbers.add(number);
            }
            if (ValidationUtil.isOdd(number)) {
                oddNumbers.add(number);
            }
            if (ValidationUtil.isPerfectSquare(number)) {
                perfectSquareNumbers.add(number);
            }
        }

        System.out.print("Number is Odd:");
        printList(oddNumbers);
        System.out.print("Number is Even:");
        printList(evenNumbers);
        System.out.print("Number is Perfect Square:");
        printList(perfectSquareNumbers);

        System.out.println();
    }

    public void solveSuperlativeEquation() {
        float a = ValidationUtil.inputForFloat("Enter A");
        float b = ValidationUtil.inputForFloat("Enter B");

        List<Float> solutions = calculateEquation(a, b);

        if (solutions == null) {
            System.out.println("No solution for the superlative equation.");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions for the superlative equation.");
        } else {
            System.out.println("Solution: x = " + solutions.get(0));

            // Kiểm tra tính chất của số a, b và nghiệm
            checkProperties(a, b, solutions);
        }
    }
}
