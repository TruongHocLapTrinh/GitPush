/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DictionaryController;
import model.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    private DictionaryController dictionaryController = new DictionaryController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Add Word","Delete Word","Translate","Exit"};
        Menu<String> homeMenu = new Menu<String>("Dictionary Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        addWord();
                        break;
                    case 2:
                        removeWord();
                        break;
                    case 3:
                        translateWord();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
        System.out.println("");
    }
    
    private void addWord(){
        String eng = validationUtil.inputWithOutEmpty("Enter English").trim().toLowerCase();
        if (dictionaryController.checkKey(eng)) {
            System.out.println(eng + " is in dictionary !!!");
        } else {
            String vi = validationUtil.inputWithOutEmpty("Enter Vietnamese").trim().toLowerCase();
            dictionaryController.addWord(eng, vi);
            System.out.println("Add successfully !!!");
        }
    }
    
    private void removeWord(){
        String eng = validationUtil.inputWithOutEmpty("Enter English").trim().toLowerCase();
        if (!dictionaryController.checkKey(eng)) {
            System.out.println("Not found '" + eng + "' !!!");
        } else {
            dictionaryController.removeWord(eng);
            System.out.println("Remove " + eng + " successfully !!!");
        }
    }
    
    private void translateWord(){
        String eng = validationUtil.inputWithOutEmpty("Enter English").trim().toLowerCase();
        if (!dictionaryController.checkKey(eng)) {
            System.out.println("Empty !!!");
        } else {
            String vi = dictionaryController.translateWord(eng);
            System.out.println("Vietnamese : " + vi);
        }
    }
}
