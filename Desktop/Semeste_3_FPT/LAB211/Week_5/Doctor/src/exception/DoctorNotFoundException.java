/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author PC
 */
public class DoctorNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Doctor does not exist !!!";
    }
    
}
