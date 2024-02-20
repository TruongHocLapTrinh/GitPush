/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import model.BinarySearch;
import model.Util;
import model.BubbleSort;
import model.LinearSearch;
import model.QuickSort;

public class Controller {

    private final static Util util = new Util();
    private final static QuickSort quickSort = new QuickSort();
    private final static BubbleSort bubbleSort = new BubbleSort();
    private final static LinearSearch linearSearch = new LinearSearch();
    private final static BinarySearch binarySearch = new BinarySearch();
    
    public void quickSort(){        
        int size = Integer.parseInt(util.getInput("Enter number of array"));
        int[] arr = util.generateRandomArray(size);
        util.displayArray("Unsorted array", arr);
        quickSort.doQuickSort(arr, 0, size-1);
        util.displayArray("Sorted Array", arr);
              
    }

    public void bubbleSort() {
        int size = Integer.parseInt(util.getInput("Enter number of array"));
        int[] arr = util.generateRandomArray(size);
        util.displayArray("Unsorted array", arr);
        
        bubbleSort.doBubbleSort(arr);
        util.displayArray("Sorted array", arr);
    }

    public void linearSearch() {
        int size = Integer.parseInt(util.getInput("Enter number of array"));
        int[] arr = util.generateRandomArray(size);
               
        int value = Integer.parseInt(util.getInput("Enter search value"));
        
        List<Integer> res = linearSearch.doLinearSearch(arr, value);
        
        util.displayArray("The array", arr);
        
        if (!res.isEmpty()) {
            System.out.println("Found " + value + " at index : " + res.toString());
        } else {
            System.out.println(value + " is not found in array !!!");
        } 
        
    }

    public void binarySearch() {
        int size = Integer.parseInt(util.getInput("Enter number of array"));
        int[] arr = util.generateRandomArray(size);
        
        quickSort.doQuickSort(arr, 0, size-1);
        util.displayArray("Sorted Array", arr);
        
        int value = Integer.parseInt(util.getInput("Enter search value"));
        int index = binarySearch.doBinarySearch(arr, 0, size-1, value);
        
        if (index != -1) {
            System.out.println("Found " + value + " at index : " + index);
        } else
            System.out.println(value + " is not found in array !!!");
        
    }
    
}
