/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Contact;
import model.ContactService;

/**
 *
 * @author PC
 */
public class ContactController {
    private ContactService contactService = new ContactService();
    
    public List<Contact> getAll() {
        return contactService.findAll();
    }

    public void addContact(Contact contact) {
        contactService.addContact(contact);
    }

    public boolean removeContactById(int id) {
        return contactService.removeContactById(id);
    }

    
}
