/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

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
    public int inputForParseDouble(String field){
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)){
            res = inputWithOutEmpty("Input number !!! Please input again");
          
        }
        return Integer.parseInt(res);
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
            res = inputWithOutEmpty("Email is wrong format (<account name>@<domain>. (eg: annguyen@fpt.edu.vn)) !!!. Please input again");
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

    public int inputYearOfExp(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < 0 || Integer.parseInt(res)> 100){
            if (!isInteger(res)) {
                res = inputWithOutEmpty("Pls input number !!! Please input again");
            } else {
                res = inputWithOutEmpty("Exp must from 0 to 100 !!! Please input again");
            }

        }

        return Integer.parseInt(res);
    }
    
    public String inputGraduationRank(String field){
        String res = inputWithOutEmpty(field).trim();
        while (!res.equalsIgnoreCase("Excellence") && !res.equalsIgnoreCase("Good")
                && !res.equalsIgnoreCase("Fair") && !res.equalsIgnoreCase("Poor")){
            res = inputWithOutEmpty("Graduation Rank must be Excellence/ Good/ Fair/ Poor !!!. Please input again");
        }

        return res;
    }
    
    public int inputCandidateTypeFrom0to2(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < 0 || Integer.parseInt(res) > 2){
            if (!isInteger(res)) {
                res = inputWithOutEmpty("Pls input number !!! Please input again");
            } else {
                res = inputWithOutEmpty("Invalid choice !!! Please input again");
            }
         
        }

        return Integer.parseInt(res);
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
