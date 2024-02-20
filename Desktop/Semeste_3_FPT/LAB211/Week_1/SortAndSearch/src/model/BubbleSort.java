/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class BubbleSort {

    public BubbleSort() {
    }
    
    public void doBubbleSort(int[] arr) {
        for (int i=0; i < arr.length - 1; i++) {
            
            for (int j = 0; j < arr.length - i - 1; j++) {
                
                if (arr[j] > arr[j+1]) {                  
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;                    
                }
            }
        }
    }
    
}
