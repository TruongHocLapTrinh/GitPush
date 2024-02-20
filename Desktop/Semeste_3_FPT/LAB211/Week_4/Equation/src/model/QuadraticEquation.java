package model;

import Util.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class QuadraticEquation extends AbstractEquation {

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new java.util.ArrayList<>();

        float discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            // No solution
            return null;
        } 
//        else if (discriminant == 0) {
//            // Single solution
//            float solution = -b / (2 * a);
//            solutions.add(solution);
//        } 
        else {
            // Nghiem kep va 2 nghiem
            float solution1 = (-b + (float) Math.sqrt(discriminant)) / (2 * a);
            float solution2 = (-b - (float) Math.sqrt(discriminant)) / (2 * a);
            solutions.add(solution1);
            solutions.add(solution2);
        }

        return solutions;
    }

    private void checkProperties(float a, float b, float c, List<Float> solutions) {
        List<Float> allNumbers = new ArrayList<>();

        allNumbers.add(a);
        allNumbers.add(b);
        allNumbers.add(c);
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

    public void solveQuadraticEquation() {
        float a = ValidationUtil.inputForFloat("Enter A");
        float b = ValidationUtil.inputForFloat("Enter B");
        float c = ValidationUtil.inputForFloat("Enter C");

        List<Float> solutions = calculateQuadraticEquation(a, b, c);

        if (solutions == null) {
            System.out.println("No solution for the quadratic equation.");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions for the quadratic equation.");
        } else {
            System.out.println("Solutions: x1 = " + solutions.get(0) + " and x2 = " + solutions.get(1));
            checkProperties(a, b, c, solutions);
        }
    }

}
