/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Course {
    private int courseId;
    private int count;
    private String title;
    
    public Course() {
    }

    public Course(int courseId) {
        this.courseId = courseId;
        this.count = 1;
        setTitle(courseId);
    }
    
    
    
    public int getCourseId() {
        switch (courseId) {
            case 1 -> this.title = "Java";
            case 2 -> this.title = "C/C++";
            case 3 -> this.title = ".Net";
        }
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        switch (courseId) {
            case 1 -> this.title = "Java";
            case 2 -> this.title = "C/C++";
            case 3 -> this.title = ".Net";
        }
        return title;
    }

    public void setTitle(int courseId) {
        switch (courseId) {
            case 1 -> this.title = "Java";
            case 2 -> this.title = "C/C++";
            case 3 -> this.title = ".Net";
        }
    }

    @Override
    public String toString() {
//        return "Course{" + "courseId=" + courseId + ", count=" + count + ", title=" + getTitle() + '}';
        return title;
    }

    
    
}
