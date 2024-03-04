/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.DataFormatController;
import Model.DataFormat;
import Util.Menu;
import Util.ValidationUtil;

public class HomeView {
    private DataFormatController dataFormatController = new DataFormatController();
    private ValidationUtil validationUtil = new ValidationUtil();
    public void show() {
        String[] options = {"Validate Data Format", "Exit"};
        Menu<String> homeMenu = new Menu<>("Validate Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        validateDataFormat();
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
    }

    public void validateDataFormat() {
        String phone;
        String email;
        String date;
        do {            
            phone = validationUtil.inputWithOutEmpty("Enter Phone");
            if (!dataFormatController.checkPhone(phone)) {
                System.out.println("Phone must be minimum 10 characters and must contain 10 digit ");
            }
        } while (!dataFormatController.checkPhone(phone));
        
        do {            
            email = validationUtil.inputWithOutEmpty("Enter Mail");
            if (!dataFormatController.checkEmail(email)) {
                System.out.println("Email is wrong format (<account name>@<domain>. (eg: annguyen@fpt.edu.vn)) !!!. Please input again");
            }
        } while (!dataFormatController.checkEmail(email));
        
        do {            
            date = validationUtil.inputWithOutEmpty("Enter Date");
            if (!dataFormatController.checkDate(date)) {
                System.out.println("Date must be in correct format (dd/MM/yyyy). Please try again");
            }
        } while (!dataFormatController.checkDate(date));
    }
}

