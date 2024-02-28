/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;
import model.StudentService;

/**
 *
 * @author PC
 */
public class StudentController {
    private StudentService studentService = new StudentService();

    public void save(Student student) {
        studentService.save(student);
    }

    public List<Student> findAll() {
        return studentService.findAll();
    }
    
}
