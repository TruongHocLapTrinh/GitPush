/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author PC
 */
public class ShoppingCart {
    private final static HashMap<String, List<Fruit>> shoppingCart;
    static {
        shoppingCart = new HashMap<>();
    }

    public void addToCart(String customerName, Fruit fruit, int amount) {
        if (isCustomerExist(customerName)) {
            shoppingCart.get(customerName).add(fruit);
            shoppingCart.get(customerName).get(shoppingCart.get(customerName).indexOf(fruit)).setQuantity(fruit.getQuantity() + amount);
        } else {
            shoppingCart.put(customerName, new ArrayList<>());
            shoppingCart.get(customerName).add(fruit);
            shoppingCart.get(customerName).get(shoppingCart.get(customerName).indexOf(fruit)).setQuantity(fruit.getQuantity() + amount);
        }
        
    }
    
    private boolean isCustomerExist(String customer){
        for (String key : shoppingCart.keySet()) {
            if (customer.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public List<Fruit> showOrderList(String customerName) {
        return shoppingCart.get(customerName);
    }

    public double showTotalSpend(String customerName) {
        List<Fruit> fruits = shoppingCart.get(customerName);
        double totalSpend = 0.0;
        for (Fruit fruit : fruits) {
            totalSpend = totalSpend + fruit.getPrice()*fruit.getQuantity();
        }
        return totalSpend;
    }

    public HashMap<String, List<Fruit>> findAll() {
        return shoppingCart;
    }
}
