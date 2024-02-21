/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;


import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ValidationUtil {

    
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
        
    public int inputIntegerLimit(String field, int low, int high) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) < low || Integer.parseInt(res) > high){
            if (!isInteger(res)) {
                res = inputWithOutEmpty("Pls input number !!! Please input again");
            } else {
                res = inputWithOutEmpty("Invalid !!! Input from "+ low + " to " + high);
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
    //======================================================
}
