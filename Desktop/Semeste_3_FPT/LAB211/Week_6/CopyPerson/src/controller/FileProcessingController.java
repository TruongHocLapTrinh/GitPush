/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.util.List;
import model.Person;
import model.PersonService;

/**
 *
 * @author PC
 */
public class FileProcessingController {
    
    private PersonService personService = new PersonService();

    public List<Person> getPerson(String filePath, double salary){
        return personService.getPerson(filePath, salary);
    }

    public void copyWordOneTimes(String source, String destination) {
        personService.copyWordOneTimes(source, destination);
    }
    
    public boolean checkFileExist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
    
}
