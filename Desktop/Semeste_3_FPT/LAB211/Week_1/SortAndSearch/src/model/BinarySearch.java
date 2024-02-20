/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.util.List;

/**
 *
 * @author PC
 */
public class BinarySearch {

    public BinarySearch() {
    }
    
    public int doBinarySearch(int [] array,int left, int right, int value) {
        if (right >= left) {
            int mid = (left + right)/2 ;
            if (value < array[mid]) {
                return doBinarySearch(array, left, mid-1, value);
            }
            else if (value > array[mid]) {
                return doBinarySearch(array, mid+1, right, value);
            }
            else return mid;
        }
        return -1;
    }
}
