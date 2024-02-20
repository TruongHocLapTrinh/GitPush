/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import model.Fruit;
import model.ShoppingCart;
import model.ShoppingService;
import view.ShoppingView;

/**
 *
 * @author PC
 */
public class ShoppingController {
    private final ShoppingView shoppingView = new ShoppingView();
    private final ShoppingService shoppingService = new ShoppingService();
    private final ShoppingCart shoppingCart = new ShoppingCart();
    
    public void createFruit() {
        Fruit fruit = shoppingView.createFruitForm();
        shoppingService.save(fruit);
    }

    public List<Fruit> findAll() {
        return shoppingService.findAll();
    }

    public void viewOrder(String customerName) {
        shoppingView.viewOrder(customerName, findAll());
    }

    public void orderFruit(String customerName, int idFruit, int amount) {
        Fruit fruit = shoppingService.findFruitById(idFruit);
        if (shoppingService.checkFruitAvailable(idFruit, amount)) {
            fruit.setQuantity(amount);
            shoppingCart.addToCart(customerName, fruit, amount);
            shoppingService.decreaseQuantity(idFruit, amount);
            shoppingView.showOrderSuccessfull(customerName,fruit);
        } else {
            shoppingView.showOrderFail(customerName, fruit);
        } 
        
    }

    public List<Fruit> showOrderList(String customerName) {
        return shoppingCart.showOrderList(customerName);
    }

    public double showTotalSpend(String customerName) {
        return shoppingCart.showTotalSpend(customerName);
    }

    public HashMap<String, List<Fruit>> findAllOrder() {
        return shoppingCart.findAll();
    }



    
    
}
