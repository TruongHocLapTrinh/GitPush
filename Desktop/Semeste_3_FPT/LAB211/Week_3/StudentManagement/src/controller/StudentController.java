/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Util.ValidationUtil;
import java.util.List;

import model.Course;
import model.Student;
import model.StudentService;

/**
 *
 * @author PC
 */
public class StudentController {
    
    private final StudentService studentService = new StudentService();
    private final ValidationUtil validationUtil = new ValidationUtil();
    
    public void doCreateStudent() {
//        int id = validationUtil.inputForParseInteger("ID");
        String name = validationUtil.inputWithOutEmpty("Name");
        String semester = validationUtil.inputWithOutEmpty("Semester");
        int courseId = validationUtil.inputIntegerLimit("Course id : (1.Java/ 2.C/C++ / 3. .Net)", 1, 3);
        Course course = new Course(courseId);
        Student student = new Student(name, semester, course);
        
        studentService.save(student);
        
    }

    public List<Student> findAndSortStudentByName() {
        String name = validationUtil.inputWithOutEmpty("Name").toLowerCase();
        return studentService.findAndSortStudent((Student p)-> p.getName().toLowerCase().contains(name));
    }

    public List<Student> reportStudent() {
        return studentService.findAll();
    }

    public void updateOrDelete() {
        int id = validationUtil.inputForParseInteger("Student ID");
        Student student = studentService.findStudentById(id);
        System.out.println(student);
        
        String choice;
        do {            
            choice = validationUtil.inputWithOutEmpty("Do you want to update (U) or delete (D) student").toUpperCase();
            if (!choice.equals("U") && !choice.equals("D")) {
                System.out.println("Invalid choice !!!");
            }
        } while (!choice.equals("U") && !choice.equals("D"));
    
        switch (choice) {
            case "U" -> {
                System.out.println("Update student with ID : " + id);
               
                String name = validationUtil.inputWithOutEmpty("Update Name");                
                String semester = validationUtil.inputWithOutEmpty("Update semester");
                int courseId = validationUtil.inputIntegerLimit("Course id : (1.Java/ 2.C/C++ / 3. .Net)", 1, 3);
                studentService.save(new Student(id, name, semester, new Course(courseId)));
                System.out.println("Update Successfull !!!");
            }
            case "D" -> {
                studentService.remove(student);
                System.out.println("Deleting successfull !!!");
            }
        }
    }

    public void addCourse() {
        studentService.findAll().forEach(System.out::println);
        int id = validationUtil.inputIntegerLimit("Choose student id to add course", 1, studentService.findAll().size());
        int courseId = validationUtil.inputIntegerLimit("Add Course id : (1.Java/ 2.C/C++ / 3. .Net)", 1, 3);
        Student student = studentService.findStudentById(id);
        studentService.addCourse(student, courseId);
    }
    
    
    
}
