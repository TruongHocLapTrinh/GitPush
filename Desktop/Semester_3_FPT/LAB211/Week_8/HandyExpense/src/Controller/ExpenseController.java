/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.Expense;
import Model.HandyExpense;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ExpenseController {
    private HandyExpense handyExpense = new HandyExpense();

    public void save(Expense expense) {
        handyExpense.save(expense);
    }

    public List<Expense> findAll() {
        return handyExpense.findAll();
    }
    
    public boolean removeExpenseById(int id) {
        return handyExpense.removeExpenseById(id);
    }
}
