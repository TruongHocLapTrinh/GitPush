/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author PC
 */
public class AnalysisString {
    private String string;
    public AnalysisString() {
    }

    public AnalysisString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    public HashMap<String, List<Integer>> getNumber(){
        HashMap<String, List<Integer>> numberResultHM = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> perfectSquareNumbers = new ArrayList<>();
        
        StringBuilder temp = new StringBuilder();

        for (char ch : string.toCharArray()) {
            if (Character.isDigit(ch)) {
                temp.append(ch);
            } else if (temp.length() > 0) {
                int num = Integer.parseInt(temp.toString());
                allNumbers.add(num);
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }

                int sqrt = (int) Math.sqrt(num);
                if (sqrt * sqrt == num) {
                    perfectSquareNumbers.add(num);
                }

                temp.setLength(0);
            }
        }
       
        numberResultHM.put("Perfect Square Numbers", perfectSquareNumbers);
        numberResultHM.put("Odd Numbers", oddNumbers);
        numberResultHM.put("Even Numbers", evenNumbers);
        numberResultHM.put("All Number", allNumbers);
      
        return numberResultHM;
    }
    
    public HashMap<String, StringBuilder> getCharacter() {
        HashMap<String, StringBuilder> characterResultHM = new HashMap<>();
        StringBuilder allChars = new StringBuilder();
        StringBuilder uppercaseChars = new StringBuilder();
        StringBuilder lowercaseChars = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (char ch : string.toCharArray()) {
            if (!Character.isDigit(ch)) {
                allChars.append(ch);
            }
           
            if (Character.isUpperCase(ch)) {
                uppercaseChars.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercaseChars.append(ch);
            } else if (!Character.isLetterOrDigit(ch)) {
                specialChars.append(ch);
            }
        }
       
        characterResultHM.put("Uppercase Characters", uppercaseChars);
        characterResultHM.put("Lowercase Characters", lowercaseChars);
        characterResultHM.put("Special Characters", specialChars);
        characterResultHM.put("All character", allChars);
        
        return characterResultHM;
    }
}
