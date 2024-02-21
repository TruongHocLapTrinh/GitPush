/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FileProcessingController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import model.Menu;
import model.Person;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    private FileProcessingController fileProcessingController = new FileProcessingController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Find Person Info", "Coppy Text to new file", "Exit"};
        Menu<String> homeMenu = new Menu<String>("File Processing", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        getPerson();
                        break;
                    case 2:
                        copyWordOneTimes();
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
    
    private void getPerson(){
        String filePath;
        do {            
            filePath = validationUtil.inputWithOutEmpty("Emter Path");
            if (!fileProcessingController.checkFileExist(filePath)) {
                System.out.println("File not found !!!");
            }
        } while (!fileProcessingController.checkFileExist(filePath));
     
        double salary = validationUtil.inputDoubleGreaterThan("Enter salary", 0);
        
        List<Person> personList = fileProcessingController.getPerson(filePath, salary);
        
        System.out.println(String.format("%-10s %-10s %-10s", "Name", "Address", "Salary"));
        if (personList.isEmpty()) {
            System.out.println("No info related !!!");
        } else if (personList.size() == 1) {
            personList.forEach(System.out::println);
        } else {
            personList.forEach(System.out::println);
            System.out.print("Max : ");
            System.out.println(personList.get(0));
            System.out.print("Min : ");
            System.out.println(personList.get(personList.size()-1));
        }
        
    }
    
    public void copyWordOneTimes(){
        String source;
        do {            
            source = validationUtil.inputWithOutEmpty("Emter Path");
            if (!fileProcessingController.checkFileExist(source)) {
                System.out.println("File not found !!!");
            }
        } while (!fileProcessingController.checkFileExist(source));
        
        String destination = validationUtil.inputWithOutEmpty("Enter new file name");
        try {
            fileProcessingController.copyWordOneTimes(source, destination);
            System.out.println("Copy done...");
        } catch (Exception e) {
            System.out.println("Error !!!");
        }
        
        
    }
}
