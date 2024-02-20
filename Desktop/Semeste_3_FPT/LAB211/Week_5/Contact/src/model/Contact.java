/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Contact {
    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;

    public Contact() {
    }

    public Contact(int id, String fullName, String group, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    
    public Contact(String fullName, String group, String address, String phone) {
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return this.fullName.split(" ")[0];
    }

    public String getLastName() {
        return this.fullName.split(" ")[fullName.split(" ").length-1];
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    @Override
    public String toString() {
//        return "Contact{" + "id=" + id + ", fullName=" + fullName + ", firstName=" + firstName + ", lastName=" + lastName + ", group=" + group + ", address=" + address + ", phone=" + phone + '}';
        return String.format("|%-3s|%-16s|%-12s|%-12s|%-8s|%-12s|%-14s|",id, fullName, getFirstName(), getLastName(), group, address, phone);
    }
  
}