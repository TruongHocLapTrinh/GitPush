package Util;

import java.util.Scanner;

public class ValidationUtil {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    // Validation input without empty
    public static String inputWithOutEmpty(String field) {
        String res = null;

        do {
            System.out.printf(res != null ? "This %s cannot empty. Please input again : " : field + " : ", field);
            res = getScanner().nextLine();
        } while (res.isBlank());

        return res;
    }

    // Validation input for Integer.parseInt(input) such as int id;
    public static int inputForParseInteger(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)) {
            res = inputWithOutEmpty("Input number !!! Please input again");
        }
        return Integer.parseInt(res);
    }

    public static float inputForFloat(String field) {
        String res = inputWithOutEmpty(field);
        while (!isFloat(res)) {
            res = inputWithOutEmpty("Input number !!! Please input again");
        }
        return Float.parseFloat(res);
    }

    // Validation input for Double.parseDouble(input) such as double price;
    public static int inputForParseDouble(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)) {
            res = inputWithOutEmpty("Input number !!! Please input again");
        }
        return Integer.parseInt(res);
    }

    public static int inputIntegerLimit(String field, int low, int high) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < low || Integer.parseInt(res) > high) {
            if (!isInteger(res)) {
                res = inputWithOutEmpty("Pls input number !!! Please input again");
            } else {
                res = inputWithOutEmpty("Invalid !!! Input from " + low + " to " + high);
            }

        }

        return Integer.parseInt(res);
    }

    private static boolean isInteger(String val) {
        if (val == null) {
            return false;
        }

        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String val) {
        if (val == null) {
            return false;
        }

        try {
            Float.parseFloat(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String val) {
        if (val == null) {
            return false;
        }

        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public static boolean isEven(float number) {
        return number % 2 == 0;
    }

    public static boolean isPerfectSquare(float number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}
