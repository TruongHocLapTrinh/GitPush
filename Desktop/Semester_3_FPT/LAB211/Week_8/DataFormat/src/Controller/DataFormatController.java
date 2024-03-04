/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DataFormat;
import Util.ValidationUtil;

public class DataFormatController {
    private ValidationUtil validationUtil = new ValidationUtil();

    public boolean checkPhone(String phone) {
        return new DataFormat().checkPhone(phone);
    }
    
    public boolean checkEmail(String email) {
        return new DataFormat().checkEmail(email);
    }
    
    public boolean checkDate(String date){
        return new DataFormat().checkDate(date);
    }
}

