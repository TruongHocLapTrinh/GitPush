/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import model.Doctor;
import model.DoctorService;

/**
 *
 * @author PC
 */
public class DoctorController {
    private DoctorService doctorService = new DoctorService();
    
    public HashMap<String, Doctor> findAll() {
        return doctorService.findAll();
    }

    public void addDoctor(Doctor doctor) {
        doctorService.save(doctor);
    }

    public void removeDoctorByCode(String code) {
        doctorService.removeDoctorByCode(code);
    }

    public List<Doctor> searchDoctorByAllField(String text) {
        return doctorService.searchDoctorByAllField((
                    Doctor e )-> e.getCode().contains(text)
                            || e.getName().contains(text)
                            || e.getSpecialization().contains(text)
                            );
    }

    public Doctor findDoctorByCode(String code) {
        return doctorService.findDoctorByCode(code);
    }

    public void updateDoctor(Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }

    public void saveFile() {
        doctorService.writeToCSV();
    }
    
}
