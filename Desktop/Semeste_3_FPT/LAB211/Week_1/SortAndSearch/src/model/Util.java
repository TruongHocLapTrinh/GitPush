/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Util {

    public Util() {
    }
    
    public void displayArray(String msg, int [] array) {
        System.out.println(msg + " : " + Arrays.toString(array));
    }
    
    
    
    
    public int[] generateRandomArray(int size) {
       
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size - 1) + 1;
        }

        return array;
    }
    
    public String getInput(String msg) {
        System.out.println(msg);
        return new Scanner(System.in).nextLine();
    }
    
}
