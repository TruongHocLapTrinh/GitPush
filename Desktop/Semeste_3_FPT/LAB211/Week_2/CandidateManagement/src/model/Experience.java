/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience() {
        super();
    }

    public Experience(int expInYear, String proSkill, String candidate_id, String firstName, String lastName, int birthdate, String address, String phone, String email, int candidate_type) {
        super(candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String ProSkill) {
        this.proSkill = ProSkill;
    }

    @Override
    public String toString() {
        return "Experience{" + "expInYear=" + expInYear + ", proSkill=" + proSkill + '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
   
    
    
}
