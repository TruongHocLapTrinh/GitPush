/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Util.ValidationUtil;
import controller.ShoppingController;
import java.util.List;
import model.Fruit;

/**
 *
 * @author PC
 */
public class ShoppingView {
    private final ValidationUtil validationUtil = new ValidationUtil();
    
    public Fruit createFruitForm() {
        String fruitName = validationUtil.inputWithOutEmpty("Fruit Name");
        double price = validationUtil.inputForParseDouble("Fruit Price");
        int quantity = validationUtil.inputForParseInteger("Fruit quantity");
        String origin = validationUtil.inputWithOutEmpty("Fruit origin");
        return new Fruit(fruitName,price,quantity,origin);
    }

    public void viewOrder(String customerName ,List<Fruit> fruitList) {
        ShoppingController shoppingController = new ShoppingController();
        fruitList.forEach(System.out::println);
        int idFruit = validationUtil.inputIntegerLimit("Choose fruit", 1 , fruitList.size());
        int amount = validationUtil.inputForParseInteger("Amount");
        shoppingController.orderFruit(customerName, idFruit, amount);
    }

    public void showOrderSuccessfull(String customerName,Fruit fruit) {
        ShoppingController shoppingController = new ShoppingController();
        System.out.println(fruit.getFruitName() + " add to cart successfull !!!");
        String choice = validationUtil.inputWithOutEmpty("Do want to order (Y/N)").trim().toUpperCase();
        switch (choice) {
            case "N" -> viewOrder(customerName, shoppingController.findAll());
            case "Y" -> {
                List<Fruit> orderList = shoppingController.showOrderList(customerName);
                orderList.forEach(System.out::println);
                double totalSpend = shoppingController.showTotalSpend(customerName);
                System.out.println("Total : " + totalSpend);
            }   
        }
    }

    public void showOrderFail(String customerName, Fruit fruit) {
        ShoppingController shoppingController = new ShoppingController();
        System.out.println(fruit.getFruitName() + " was sold out !!!");
        viewOrder(customerName, shoppingController.findAll());
    }
    
}
