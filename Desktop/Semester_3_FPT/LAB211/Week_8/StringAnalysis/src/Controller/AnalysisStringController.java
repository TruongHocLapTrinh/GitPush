/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.HashMap;
import java.util.List;
import model.AnalysisString;


/**
 *
 * @author PC
 */
public class AnalysisStringController {
    AnalysisString analysisString = new AnalysisString();
    
    public HashMap<String, List<Integer>> getNumbers(String string) {
       analysisString.setString(string);
       return analysisString.getNumber();
    }
    
    public HashMap<String, StringBuilder> getCharacters(String string) {
       analysisString.setString(string);
       return analysisString.getCharacter();
    }
    
}
