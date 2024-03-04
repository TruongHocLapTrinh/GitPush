/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.PersonController;
import Model.Person;
import Util.Menu;
import Util.ValidationUtil;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HomeView {
    private PersonController personController = new PersonController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Input person infomation", "Display all person", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Person Management Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        inputPersonInfo();
                        break;
                    case 2:
                        displayPersonList();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
    }
    
    private void inputPersonInfo(){
        do {
            String name = validationUtil.inputWithOutEmpty("Name");
            String address = validationUtil.inputWithOutEmpty("Address");
            double salary = validationUtil.inputForParseDouble("Salary");
            personController.save(new Person(name, address, salary));
        } while (validationUtil.getChoiceYorN("Do you want to enter more person information?(Y/N)"));
    }
    
    private void displayPersonList(){
        List<Person> per = personController.findAll();
        Collections.sort(per);
        
        System.out.println(String.format("%-10s | %-10s | %-10s", "Name", "Address", "Salary"));
        per.forEach(System.out::println);
    }
}
