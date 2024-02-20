/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Fresher extends Candidate{
    private LocalDate graduation_date;
    private String graduation_rank;   // 4 value : Excellence, Good, Fair, Poor
    private String education;         // university name

    public Fresher() {
        super();
    }

    public Fresher(LocalDate graduation_date, String graduation_rank, String education, String candidate_id, String firstName, String lastName, int birthdate, String address, String phone, String email, int candidate_type) {
        super(candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public LocalDate getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(LocalDate graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" + "graduation_date=" + graduation_date + ", graduation_rank=" + graduation_rank + ", education=" + education + '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
    
    
    
}
