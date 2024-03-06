/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ExpenseController;
import Model.Expense;
import Model.HandyExpense;
import Util.Menu;
import Util.ValidationUtil;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HomeView {
    private ValidationUtil validationUtil = new ValidationUtil();
    private HandyExpense expenseList = new HandyExpense();
    private ExpenseController expenseController = new ExpenseController();
    
    public void show() {
        String[] options = {"Add an expense","Display all expenses","Delete an expense", "Exit"};
        Menu<String> homeMenu = new Menu<>("Handy Expense Program", options) {
            @Override
            @SuppressWarnings("fallthrough")
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        addExpense();
                        break;
                    case 2:
                        displayAllExpense();
                        break;
                    case 3:
                        deleteExpense();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
    }
    
    public void addExpense(){
        String date = validationUtil.inputDate("Enter date");
        double amount = validationUtil.inputForParseDouble("Enter amount");
        String content = validationUtil.inputWithOutEmpty("Enter content");
        
        expenseController.save(new Expense(date, amount, content));
        System.out.println("Expense added successfully.");
    }
    
    public void displayAllExpense() {
        List<Expense> exp = expenseController.findAll();

        if (exp.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println(String.format("%-10s | %-10s | %-10s | %-10s", "ID", "Date", "Amount", "Content"));
            exp.forEach(System.out::println);
        }
    }

    public void deleteExpense() {
        int id = validationUtil.inputForParseInteger("Enter ID");
        if (expenseController.removeExpenseById(id)) {
            System.out.println("Delete expense with Id '" + id + "' successfully!");
        } else {
            System.out.println("Expense with Id '" + id + "' not found.");
        }
    }

}
