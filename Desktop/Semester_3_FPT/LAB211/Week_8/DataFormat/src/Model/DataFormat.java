/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */

public class DataFormat {
    private String phone;
    private String email;
    private String date;
    
    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public DataFormat() {
    }

    public DataFormat(String phone, String email, String date) {
        this.phone = phone;
        this.email = email;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean checkPhone(String phone) {
        return phone.matches("^\\d{10}\\d*$");
    }
    
    public boolean checkEmail(String mail){
        return mail.matches(EMAIL_VALID);
    }
    
    public boolean checkDate(String date){
        return isValidDate(date);
    }
    
    public boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
