package model;

public class BMICalculator {

    public enum Status {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, SHOULD_LOSE_WEIGHT, SHOULD_LOSE_WEIGHT_IMMEDIATELY
    }

    public static Status calculateBMIStatus(double bmi) {
        if (bmi < 19) {
            return Status.UNDER_STANDARD;
        } else if (bmi <= 25) {
            return Status.STANDARD;
        } else if (bmi <= 30) {
            return Status.OVERWEIGHT;
        } else if (bmi <= 40) {
            return Status.SHOULD_LOSE_WEIGHT;
        } else {
            return Status.SHOULD_LOSE_WEIGHT_IMMEDIATELY;
        }
    }

    public double calculateBMI(double weight, double height) {
        height = height/100.0;
        return weight / (height * height);
    }
}
