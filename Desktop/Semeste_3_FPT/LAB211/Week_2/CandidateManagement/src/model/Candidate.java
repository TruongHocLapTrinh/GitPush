/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public abstract class Candidate {
    protected String candidate_id;
    protected String firstName;
    protected String lastName;
    protected int birthdate;
    protected String address;
    protected String phone;
    protected String email ;
    protected int candidate_type;

    public Candidate() {
    }

    public Candidate(String candidate_id, String firstName, String lastName, int birthdate, String address, String phone, String email, int candidate_type) {
        this.candidate_id = candidate_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidate_type = candidate_type;
    }
    
    
    

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidate_type() {
        return candidate_type;
    }

    public void setCandidate_type(int candidate_type) {
        this.candidate_type = candidate_type;
    }

    @Override
    public String toString() {
        return "Candidate{" + "candidate_id=" + candidate_id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", address=" + address + ", phone=" + phone + ", email=" + email + ", candidate_type=" + candidate_type + '}';
    }
    
    
    
    public String getInfo() {
        return String.format("%10s %-10s | %-5s | %-10s | %-10s | %-15s | %-2s ", firstName, lastName, birthdate, address, phone, email, candidate_type);
    }
    
    
}
