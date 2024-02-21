/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Dictionary;

/**
 *
 * @author PC
 */
public class DictionaryController {
    private Dictionary dictionary = new Dictionary();
    
    public void addWord(String eng, String vi) {
        dictionary.addWord(eng, vi);
    }

    public void removeWord(String eng) {
        dictionary.removeWord(eng);
    }

    public String translateWord(String eng) {
        return dictionary.translateWord(eng);
    }

    public boolean checkKey(String eng) {
        return dictionary.checkKey(eng);
    }
    
    
}
