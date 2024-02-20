/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import util.ValidationUtil;

/**
 *
 * @author PC
 * @param <T>
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> options;

    public Menu(){}

    public Menu(String title, String[] options){
        this.title =title;
        this.options = new ArrayList<>();
        for(String s:options) this.options.add((T) s);
    }
    //-------------------------------------------
   
    
    public void display(){
        System.out.println("\n================================");
        System.out.println(title);
        System.out.println("--------------------------------");
        for(int i = 0; i< options.size(); i++)
            System.out.println((i+1)+"."+ options.get(i));
        System.out.println("--------------------------------");
    }
    //-------------------------------------------
    public int getSelected(){
        display();
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter selection : ");
//        return sc.nextInt();
        return new ValidationUtil().inputForParseInteger("Enter selection");
    }
    //-------------------------------------------
    public abstract void execute(int choice);
    //-------------------------------------------
    public void run(){
        while(true){
            int n=getSelected();
            execute(n);
            //if(n > options.size()) break;
        }
    }
//-------------------------------------------
    
}
