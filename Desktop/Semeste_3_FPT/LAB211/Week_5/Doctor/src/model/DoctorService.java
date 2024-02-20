/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import exception.DoctorNotFoundException;
import exception.DupplicateCodeException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author PC
 */
public class DoctorService {
    private HashMap<String, Doctor> doctorHashMap = new HashMap<>();
    private final String DOCTORFILE_PATH = "doctor.txt";

    public DoctorService() {
        try {
            readCSV();
        } catch (Exception e) {
        }

    }
          
    public HashMap<String, Doctor> findAll() {
        return doctorHashMap;
    }
    
    public void save(Doctor doctor){
        if (!doctorHashMap.containsKey(doctor.getCode())) {
            doctorHashMap.put(doctor.getCode(), doctor);
        } else 
            throw new DupplicateCodeException();
        
    }

    public void removeDoctorByCode(String code) {
        if (doctorHashMap.containsKey(code)) {
            doctorHashMap.remove(code);
        } else
            throw new DoctorNotFoundException();
    }
    
    public List<Doctor> searchDoctorByAllField(Predicate<Doctor> p){
        List<Doctor> res = new ArrayList<>();
        for (Doctor doctor : doctorHashMap.values()){
            if (p.test(doctor)) {
                res.add(doctor);
            }
        }
        return res;
    }

    public Doctor findDoctorByCode(String code) {
        for (String key: doctorHashMap.keySet()) {
            if (key.equals(code)) {
                return doctorHashMap.get(key);
            }
        }
        throw new DoctorNotFoundException();
    }

    public void updateDoctor(Doctor doctor) {
        doctorHashMap.replace(doctor.getCode(), doctor);
    }
    
    private void readCSV() throws Exception{
        FileReader fileReader = new FileReader(DOCTORFILE_PATH);
        BufferedReader br = new BufferedReader(fileReader);
        
        String line;
        while ((line = br.readLine()) != null) {            
            String[] row = line.split(",");
            String code = row[0];
            String name = row[1];
            String specialization = row[2];
            int availability = Integer.parseInt(row[3]);
            
            Doctor doctor = new Doctor(code, name, specialization, availability);
            doctorHashMap.put(code, doctor);
            
        }
    }
    
    public void writeToCSV(){
        try {
            FileWriter fileWriter = new FileWriter(DOCTORFILE_PATH, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Doctor doctor : doctorHashMap.values()){
                bufferedWriter.write(doctor.getCode() + ","
                                    + doctor.getName() + ","
                                    + doctor.getSpecialization() + ","
                                    + doctor.getAvailability() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
