/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PersonService {
    private final static List<Person> personList = new ArrayList<>();
    
    static {
        personList.add(new Person("Quoc", "Quang Nam", 5000));
        personList.add(new Person("Dat", "Da Nang", 4500));
        personList.add(new Person("Truong", "Hoi An", 4000));
    }
    
    public List<Person> findAll(){
        return personList;
    }
    
    public void save(Person person) {
        personList.add(person);
    }
}
