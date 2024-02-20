/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ContactService {
    private final static List<Contact> contactList;
    static {
        contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890"));
        contactList.add(new Contact(2, "John Terry", "Star", "England", "1234567890"));
        contactList.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890"));
    }
    
    public List<Contact> findAll() {
        return contactList;
    }

    public void addContact(Contact contact) {
        int lastId = 0;
        if (!contactList.isEmpty()) {            
            lastId = contactList.get(contactList.size()-1).getId();
        }
        contact.setId(lastId+1);
        contactList.add(contact);        
    }

    public boolean removeContactById(int id) {
        return contactList.removeIf(e -> e.getId() == id);
    }
    
}
