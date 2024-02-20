/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Util.ValidationUtil;
import controller.ShoppingController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.Menu;

/**
 *
 * @author PC
 */
public class HomeView {
//    private ShoppingView shoppingView = new ShoppingView();
    private final ShoppingController shoppingController = new ShoppingController();
    private final ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Create fruit","View orders","Shopping(for buyer)","Exit"};
        Menu<String> homeMenu = new Menu<String>("FRUIT SHOP SYSTEM", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        shoppingController.createFruit();
                        break;
                    case 2:
                        HashMap<String, List<Fruit>> shoppingCart = shoppingController.findAllOrder();
                        
                        if (!shoppingCart.isEmpty()) {
                            for (Map.Entry<String, List<Fruit>> entry : shoppingCart.entrySet()) {
                                System.out.println("Customer : " + entry.getKey());
                                for (Fruit fruit : entry.getValue()) {
                                    System.out.println(fruit);
                                }
                            }
                        }
                        
                        break;
                    case 3:
                        String customerName = validationUtil.inputWithOutEmpty("Customer Name");
                        shoppingController.viewOrder(customerName);
                        break;
                    case 4:
                        System.exit(0);
                }
            }
        };
        homeMenu.run();
    }
}
