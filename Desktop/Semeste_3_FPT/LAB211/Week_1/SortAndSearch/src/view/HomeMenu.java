/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import model.Menu;

/**
 *
 * @author PC
 */
public class HomeMenu {
    public static Controller controller = new Controller();
    
    public void show(){
        String[] options = {"Bubble Sort", "Quick Sort", "Linear Search","Binary Search", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Sort Menu", options) {
            @Override
            public void execute(int choice) {
                do {                    
                    switch (choice) {
                    case 1:
                        controller.bubbleSort();
                        break;
                    case 2:
                        controller.quickSort();
                        break;
                    case 3:
                        controller.linearSearch();
                        break;
                    case 4:
                        controller.binarySearch();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice !!!");
                    }
                    
                } while (choice < 1 && choice > options.size());
                
            }
        };
        
        homeMenu.run();
    }
}
