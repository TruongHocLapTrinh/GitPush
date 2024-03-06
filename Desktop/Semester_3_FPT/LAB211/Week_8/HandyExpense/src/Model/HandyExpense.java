/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HandyExpense {
    private final static List<Expense> expenseList = new ArrayList<>();
    
    static {
        expenseList.add(new Expense(1,"06/03/2024",1000,"Retake Fee"));
        expenseList.add(new Expense(2,"06/03/2024",2000,"Study again fee"));
        expenseList.add(new Expense(3,"06/03/2024",3000,"Change major fee"));
    }
    
    public List<Expense> findAll(){
        return expenseList;
    }
    
    public void save(Expense expense) {
        int lastID = 0;
        if (!expenseList.isEmpty()) {
            lastID = expenseList.get(expenseList.size() - 1).getID();
        }
        expense.setID(lastID+1);
        expenseList.add(expense);
    }
    
    public boolean removeExpenseById(int id) {
        return expenseList.removeIf(e -> e.getID() == id);
    }
}

