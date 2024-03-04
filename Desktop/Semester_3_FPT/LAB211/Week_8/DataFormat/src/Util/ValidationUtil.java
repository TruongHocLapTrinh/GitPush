/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ValidationUtil {
    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    private static final String PHONE_REGEX = "^\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})$";
    private static final String PHONE_NOTE = """
                                             Note: A phone number only has the following format:
                                             \u2022\t1234567890
                                             \u2022\t123-456-7890
                                             \u2022\t123-456-7890 x1234
                                             \u2022\t123-456-7890 ext1234
                                             \u2022\t(123)-456-7890
                                             \u2022\t123.456.7890
                                             \u2022\t123 456 7890\t \n""";
    
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    // Validation input without empty
    public String inputWithOutEmpty(String field){
        String res = null;

        do {
            System.out.printf(res != null ? "This %s cannot empty. Please input again : " : field + " : ", field);
            res = getScanner().nextLine();
        }while (res.isBlank());

        return res;
    }

    // Validation input for Integer.parseInt(input) such as int id;
    public int inputForParseInteger(String field){
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)){
            res = inputWithOutEmpty("Input number !!! Please input again");
            
        }
        return Integer.parseInt(res);
    }
    

    // Validation input for Double.parseDouble(input) such as double price;
    public double inputForParseDouble(String field){
        String res = inputWithOutEmpty(field);
        while (!isDouble(res)){
            res = inputWithOutEmpty("Input number !!! Please input again");
          
        }
        return Double.parseDouble(res);
    }
    
    // Validation input for FLoat.parseFloat(input);
    public int inputForParseFloat(String field){
        String res = inputWithOutEmpty(field);
        while (!isFloat(res)){
            res = inputWithOutEmpty("Input number !!! Please input again");
            
        }
        return Integer.parseInt(res);
    }
    
    public float inputForArea(String field){
        String res = inputWithOutEmpty(field);
        while (!isFloat(res) || Float.parseFloat(res) <= 0){
            if (!isFloat(res)) {
                res = inputWithOutEmpty("Input number !!! Please input again");
            } else
                res = inputWithOutEmpty("Area must be > 0 !!!");     
        }
        return Float.parseFloat(res);
    }
    
    public String inputPhoneWithMin10Char(String field){
        String res = inputWithOutEmpty(field);
        while (!res.matches("^\\d{10}\\d*$")){
            res = inputWithOutEmpty("Phone must be minimum 10 characters. Please input again");
           
        }

        return res;
    }
    
    public String inputPhone(String field){
        String res = inputWithOutEmpty(field);
        while (!res.matches(PHONE_REGEX)){
            res = inputWithOutEmpty("Phone is invalid !!!\n" + PHONE_NOTE + "Enter phone again");           
        }

        return res;
    }
    
    public String inputMail(String field){
        String res = inputWithOutEmpty(field);
        while (!res.matches(EMAIL_VALID)){
            res = inputWithOutEmpty("Email is wrong format (<account name>@<domain>. (eg: annguyen@fpt.edu.vn)) !!!. Please input again\n");
                   }

        return res;
    }
    
//     Validation input for year of birthday from 1900 to now 
    public int inputYearOfBirth(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < 1900 || Integer.parseInt(res) > Year.now().getValue()){
            if (!isInteger(res)) {
                res = inputWithOutEmpty("Pls input number !!! Please input again");
            } else {
                res = inputWithOutEmpty("Year is invalid !!! Please input again");
            }
         
        }

        return Integer.parseInt(res);
    }
// input date must be in format dd/MM/yyy
    public String inputDate(String field) {
        String res = inputWithOutEmpty(field);
        while (!isValidDate(res)) {
            res = inputWithOutEmpty("Date must be in correct format (dd/MM/yyyy). Please try again: ");
        }

        return res;
    }
// validate date 
    public boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public String inputGraduationRank(String field){
        String res = inputWithOutEmpty(field).trim();
        while (!res.equalsIgnoreCase("Excellence") && !res.equalsIgnoreCase("Good")
                && !res.equalsIgnoreCase("Fair") && !res.equalsIgnoreCase("Poor")){
            res = inputWithOutEmpty("Graduation Rank must be Excellence/ Good/ Fair/ Poor !!!. Please input again");
        }

        return res;
    }
    
//    Validation for input Integer
    public int inputIntegerInRange(String field, int low, int high) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < low || Integer.parseInt(res) > high){
            if (!isInteger(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.println("Must be from " + low + " to " + high + " !!!");
            }          
            res = inputWithOutEmpty(field);
        }

        return Integer.parseInt(res);
    }
    
    public int inputIntegerGreaterThan(String field, int low) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < low){
            if (!isInteger(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.println("Must be greater than " + low + " !!!");
            }   
            res = inputWithOutEmpty(field);
        }
        return Integer.parseInt(res);
    }
    
    public int inputIntegerLowerThan(String field, int high) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) > high){
            if (!isInteger(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.println("Must be lower than " + high + " !!!");
            }   
            res = inputWithOutEmpty(field);
        }
        return Integer.parseInt(res);
    }
    
//    Validation for input Double
    public double inputDoubleInRange(String field, double low, double high) {
        String res = inputWithOutEmpty(field);
        while (!isDouble(res) || Double.parseDouble(res) < low || Double.parseDouble(res) > high){
            if (!isDouble(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.println("Must be from " + low + " to " + high +" !!!");
            }        
            res = inputWithOutEmpty(field);
        }
        return Double.parseDouble(res);
    }
    
    public double inputDoubleGreaterThan(String field, double low) {
        String res = inputWithOutEmpty(field);
        while (!isDouble(res) || Double.parseDouble(res) < low){
            if (!isDouble(res)) {
                System.out.println("Pls input number !!! Please input again");            
            } else {
                System.out.println("Must be greater than " + low + " !!!");
            }   
            res = inputWithOutEmpty(field);
        }
        return Double.parseDouble(res);
    }
    
    public double inputDoubleLowerThan(String field, double high) {
        String res = inputWithOutEmpty(field);
        while (!isDouble(res) || Double.parseDouble(res) > high){
            if (!isDouble(res)) {
                System.out.println("Pls input number !!! Please input again");            
            } else {
                System.out.println("Must be lower than " + high + " !!!");
            }   
            res = inputWithOutEmpty(field);
        }
        return Double.parseDouble(res);
    }
    
    // get choice
    public boolean getChoiceYorN(String field){
        String res = inputWithOutEmpty(field).trim();
        while (!res.equalsIgnoreCase("Y") && !res.equalsIgnoreCase("N")) {
            System.out.println("Y/N ?");
            res = inputWithOutEmpty("Do you want to continue (Y/N)");
        }
        return res.equalsIgnoreCase("Y");
    }
    
    // ===================================================
    // This is support method for validation method above (handle NumberFormatException)
    private boolean isInteger(String val){
        if(val == null){
            return false;
        }

        try {
            Integer.parseInt(val);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    private boolean isDouble(String val){
        if(val == null){
            return false;
        }

        try {
            Double.parseDouble(val);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    private boolean isFloat(String val){
        if(val == null){
            return false;
        }

        try {
            Float.parseFloat(val);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    //======================================================
}
