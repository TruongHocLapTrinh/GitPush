/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Student{
    private int id;
    private String name;
    private String semester;
    private Course course;

    public Student() {
    }

    public Student(int id, String name, String semester, Course course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }
    
    
    
    public Student(String name, String semester, Course course) {
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%-2s | %-10s | %-10s | %3s",id, name,course.getTitle(), course.getCount());
    }

    
    
}
