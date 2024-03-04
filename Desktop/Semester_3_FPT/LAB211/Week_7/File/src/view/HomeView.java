/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.Controller;
import util.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    private ValidationUtil validationUtil = new ValidationUtil();
    private Controller controller = new Controller();
    
    public void show(){
        String[] options = {"Enter path to analys", "Exit"};
        Menu<String> homeMenu = new Menu<>("Analysis Path Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        String path = validationUtil.inputWithOutEmpty("Enter path");
                        String result = controller.checkInputPath(path);
                        System.out.println(result);
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
