/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.StudentController;
import java.util.Collections;
import java.util.List;
import model.Student;
import util.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    
    private StudentController studentController = new StudentController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Input student infomation", "Display all student", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Collection Sort Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        inputStudentInfo();
                        break;
                    case 2:
                        displayStudentList();
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
    
    private void inputStudentInfo(){
        do {
            String name = validationUtil.inputWithOutEmpty("Name");
            String classes = validationUtil.inputWithOutEmpty("Classes");
            float mark = validationUtil.inputFloatInRange("Mark", 0, 100);
            studentController.save(new Student(name, classes, mark));
        } while (validationUtil.getChoiceYorN("Do you want to enter more student information?(Y/N)"));
    }
    
    private void displayStudentList(){
        List<Student> res = studentController.findAll();
        Collections.sort(res);  // sort by name
        
        System.out.println(String.format("%-10s | %-10s | %-10s", "Name", "Classes", "Mark"));
        res.forEach(System.out::println);
    }
    
}
