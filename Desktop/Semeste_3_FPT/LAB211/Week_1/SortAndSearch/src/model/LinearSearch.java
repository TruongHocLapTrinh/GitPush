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
public class LinearSearch {

    public LinearSearch() {
    }
    
    public List<Integer> doLinearSearch(int [] array, int value){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                res.add(i);
            }
        }
        return res;
    }
}
