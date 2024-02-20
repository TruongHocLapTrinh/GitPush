/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String university_name;

    public Intern() {
        super();
    }

    public Intern(String major, String semester, String university_name, String candidate_id, String firstName, String lastName, int birthdate, String address, String phone, String email, int candidate_type) {
        super(candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
        this.major = major;
        this.semester = semester;
        this.university_name = university_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    @Override
    public String toString() {
        return "Intern{" + "major=" + major + ", semester=" + semester + ", university_name=" + university_name + '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
    
    
    
}
