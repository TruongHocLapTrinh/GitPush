/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DoctorController;
import java.util.HashMap;
import java.util.List;
import model.Doctor;
import model.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    
    private DoctorController doctorController = new DoctorController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Display list doctor", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Doctor management", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        updateDoctor();
                        break;
                    case 3:
                        removeDoctor();
                        break;
                    case 4: 
                        searchDoctorByAllField();
                        break;
                    case 5:
                        displayDoctor();
                        break;
                    case 6:
                        doctorController.saveFile();
                        System.exit(0);
                }
            }
            
        };
        homeMenu.run();
    }
    
    private void addDoctor(){
        String code = validationUtil.inputWithOutEmpty("Enter Code");
        String name = validationUtil.inputWithOutEmpty("Enter Name");
        String specialization = validationUtil.inputWithOutEmpty("Enter Specialization");
        int availability = validationUtil.inputForParseInteger("Enter Availability");
        try {
            doctorController.addDoctor(new Doctor(code, name, specialization, availability));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void displayDoctor(){
        HashMap<String, Doctor> doctorList = doctorController.findAll();
        for (Doctor doctor : doctorList.values()) {
            System.out.println(doctor);
        }
    }
    
    private void removeDoctor(){
        String code = validationUtil.inputWithOutEmpty("Enter code");
        try {
            doctorController.removeDoctorByCode(code);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }
    
    private void searchDoctorByAllField(){
        String text = validationUtil.inputWithOutEmpty("Enter text");
        List<Doctor> res = doctorController.searchDoctorByAllField(text);
        for (Doctor doctor : res) {
            System.out.println(doctor);
        }
    }
    
    private void updateDoctor(){
        String code = validationUtil.inputWithOutEmpty("Enter code");
        Doctor doctor;
        try {
            doctor = doctorController.findDoctorByCode(code);
            System.out.println(doctor);
            String name = validationUtil.inputWithOutEmpty("Enter Name");
            String specialization = validationUtil.inputWithOutEmpty("Enter Specialization");
            int availability = validationUtil.inputForParseInteger("Enter Availability");
            doctorController.updateDoctor(new Doctor(code, name, specialization, availability));
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
}
