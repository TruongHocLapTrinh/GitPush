/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.WorkerController;
import java.util.List;
import model.History;
import model.Menu;
import model.Worker;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {
    private ValidationUtil validationUtil = new ValidationUtil();
    private WorkerController workerController = new WorkerController();
    
    public void show(){
        String[] options = {"Add worker", "Up Salary", "Down salary", "Display worker",
            "Display Information salary", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Worker Management", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        addWorker();
                        System.out.println("Add successfull");
                        break;
                    case 2:
                        changeSalary("UP");
                        break;
                    case 3:
                        changeSalary("DOWN");
                        break;
                    case 4:
                        displayWorker();
                        break;
                    case 5:
                        displayLogs();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }

        };
        homeMenu.run();
    }
    
    private void addWorker(){
        System.out.println("---------- Add Worker ----------");
        
        String id;
        do {
            id = validationUtil.inputWithOutEmpty("Enter ID");
            if (workerController.checkWorkerID(id)) {
                System.out.println("Dupplicated ID !!!");
            }
        } while (workerController.checkWorkerID(id));
        
        String name = validationUtil.inputWithOutEmpty("Enter Name");
        int age = validationUtil.inputIntegerInRange("Enter Age", 18, 50);
        double salary = validationUtil.inputDoubleGreaterThan("Enter Salary", 0);
        String workLocation = validationUtil.inputWithOutEmpty("Enter Work Location");
        Worker worker = new Worker(id, name, age, salary, workLocation);
        
        workerController.addWorker(worker);
    }
    
    private void changeSalary(String status){
        System.out.println("---------- Up/Down Salary ----------");
        
        String id;
        do {
            id = validationUtil.inputWithOutEmpty("Enter ID");
            if (!workerController.checkWorkerID(id)) {
                System.out.println("Worker ID does not exist !!!");
            }
        } while (!workerController.checkWorkerID(id));
        
        double salaryChange;
        
        if (status.equals("UP")) {
            salaryChange = validationUtil.inputDoubleGreaterThan("Enter amount of money to raise", 0);
            workerController.changeSalary("UP", id, salaryChange);
        } else {
            salaryChange = validationUtil.inputDoubleInRange("Enter amount of money to cut", 0, workerController.findWorkerById(id).getSalary());
            workerController.changeSalary("DOWN", id, salaryChange);
        }
          
    }
    
    private void displayLogs(){
        System.out.println("---------- Display Information Salary ----------");
        List<History> logs = workerController.getLogs();
        
        if (logs.isEmpty()) {
            System.out.println("Do not have any change in salary");
        } else {
            System.out.println(String.format("| %-5s | %-10s | %-4s | %-10s | %-14s | %-6s | %12s |", 
                                "ID", "Name", "Age", "Salary", "Work Location", "Status", "Date"));
            logs.forEach(System.out::println);
        }
    }
    
    private void displayWorker(){
        System.out.println("---------- Display Worker ----------");
        workerController.getWorkerList().forEach(System.out::println);
    }
}
