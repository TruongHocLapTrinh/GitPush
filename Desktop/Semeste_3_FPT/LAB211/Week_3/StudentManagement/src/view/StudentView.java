/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Util.ValidationUtil;
import controller.StudentController;
import java.util.Scanner;
import model.Menu;

/**
 *
 * @author PC
 */
public class StudentView {
    
    public static StudentController studentController = new StudentController();
    public static Scanner sc = new Scanner(System.in);
    private final ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Create", "Add Course", "Find and Sort", "Update / Delete", "Report", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Welcome to student management", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        studentController.doCreateStudent();
                        
                        String option;
                        
                        do {            
                            option = validationUtil.inputWithOutEmpty("Continue (Y)/ Back to menu(N)").toUpperCase();
                            if (!option.equals("Y") && !option.equals("N")) {
                                System.out.println("Invalid choice !!!");
                            }
                        } while (!option.equals("Y") && !option.equals("N"));
                                               
                        switch (option) {
                            case "Y" -> execute(1);
                            case "N" -> show();
                        
                        }
                    }
                    case 2 -> studentController.addCourse();
                    case 3 -> studentController.findAndSortStudentByName().forEach(System.out::println);
                    case 4 -> studentController.updateOrDelete();
                    case 5 -> studentController.reportStudent().forEach(System.out::println);
                    case 6 -> System.exit(0);
                }
            }
        };
        homeMenu.run();
      
    }
    
}
