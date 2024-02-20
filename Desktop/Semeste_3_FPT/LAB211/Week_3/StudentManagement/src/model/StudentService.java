/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author PC
 */
public class StudentService{
    private final List<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Dat", "Spring 2024", new Course(1)));
        studentList.add(new Student(2, "Truong", "Summer 2024", new Course(2)));
        studentList.add(new Student(3, "Quoc", "Fall 2024", new Course(3)));
    }

    public void save(Student student) {
        if (isExist(student.getId())) {
            studentList.set(studentList.indexOf(findStudentById(student.getId())), student);        
        } else {
            int lastId = 0;
            if(!studentList.isEmpty()){
                lastId = studentList.get(studentList.size() - 1).getId();               
            }            
            student.setId(lastId + 1);
            studentList.add(student);
        }
    }
    
    public boolean isExist(int id) {
        for (Student student : studentList) {
            if (student.getId()==id) {
                return true;
            }
        }
        return false;       
    }

    public List<Student> findAndSortStudent(Predicate<Student> p){
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (p.test(student)) {
                res.add(student);
            }
        }
        res.sort((Student o1, Student o2) -> o1.getName().compareTo(o2.getName()));
        return res;
    }

    public List<Student> findAll() {
        return studentList;
    }

    public Student findStudentById(int id) {
        for (Student student : studentList){
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void remove(Student student) {
        studentList.remove(student);
    }

    public void addCourse(Student student, int courseId) {
        if (student.getCourse().getCourseId() == courseId) {
            student.getCourse().setCount(student.getCourse().getCount()+1);
        }
        else {
            Student newStudent = new Student();
            int lastId = 0;
            if(!studentList.isEmpty()){
                lastId = studentList.get(studentList.size() - 1).getId();               
            }            
            newStudent.setName(student.getName());
            newStudent.setId(lastId + 1);
            newStudent.setCourse(new Course(courseId));
            studentList.add(newStudent);            
        }
    }
  
    
}
