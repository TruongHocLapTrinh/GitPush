/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.AnalysisStringController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Menu;
import util.ValidationUtil;


/**
 *
 * @author PC
 */
public class HomeVIew {
    private ValidationUtil validationUtil = new ValidationUtil();
    private AnalysisStringController controller = new AnalysisStringController();
            
    public void show(){      
        String[] options = {"Input String", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Analysis String Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        String string = validationUtil.inputWithOutEmpty("Input String");
                        
                        for (Map.Entry<String, List<Integer>> entry : controller.getNumbers(string).entrySet()){
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }

                        for (Map.Entry<String, StringBuilder> entry : controller.getCharacters(string).entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
    }
}
