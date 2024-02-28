/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentService {
    private final static List<Student> studentList = new ArrayList<>();
    
    static {
        studentList.add(new Student("Quoc", "seb06", 90.5f));
        studentList.add(new Student("Dat", "seb06", 80f));
        studentList.add(new Student("Truong", "seb06", 85.99f));
    }
    
    public List<Student> findAll(){
        return studentList;
    }
    
    public void save(Student student) {
        studentList.add(student);
    }
}
