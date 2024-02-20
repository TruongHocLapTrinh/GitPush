/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.StringCount;

/**
 *
 * @author PC
 */
public class HomeView {
    public void show(){
        Scanner sc = new Scanner(System.in);
        String str;
        
        System.out.println("Enter your content : ");
        do {
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("Please enter your content !!!");
            }
        } while (str.isEmpty());
                
        StringCount stringCount = new StringCount();
        stringCount.countWord(str);
        stringCount.countCharacter(str);     
        stringCount.display();
    }
    
}
