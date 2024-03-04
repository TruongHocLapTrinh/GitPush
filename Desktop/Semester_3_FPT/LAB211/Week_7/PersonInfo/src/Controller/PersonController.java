/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Person;
import Model.PersonService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PersonController {
    private PersonService personService = new PersonService();

    public void save(Person person) {
        personService.save(person);
    }

    public List<Person> findAll() {
        return personService.findAll();
    }
    
}
