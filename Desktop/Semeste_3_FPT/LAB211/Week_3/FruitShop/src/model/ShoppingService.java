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
public class ShoppingService {
    private final static List<Fruit> fruitList;

    static {
        fruitList = new ArrayList<>();
        fruitList.add(new Fruit(1, "Apple", 2, 1, "Paradise"));
        fruitList.add(new Fruit(2, "Mango", 3, 3, "Viet Nam"));
        fruitList.add(new Fruit(3, "Water Melon", 5, 10, "USA"));
    }

    public void save(Fruit fruit) {
       
        int lastId = 0;
        if(!fruitList.isEmpty()){
            lastId = fruitList.get(fruitList.size() - 1).getId();               
        }  
        fruit.setId(lastId + 1);
        fruitList.add(fruit);   
    }

    public List<Fruit> findAll() {
        return fruitList;
    }
    

    public Fruit findFruitById(int id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

    public boolean checkFruitAvailable(int fruitId, int amount) {
        Fruit fruit = findFruitById(fruitId);
        return (fruit.getQuantity() - amount) >= 0;
    }

    public void decreaseQuantity(int fruitId, int amount) {
        Fruit fruit = findFruitById(fruitId);
        fruitList.get(fruitList.indexOf(fruit)).setQuantity(fruit.getQuantity() - amount);
    }
    
}
