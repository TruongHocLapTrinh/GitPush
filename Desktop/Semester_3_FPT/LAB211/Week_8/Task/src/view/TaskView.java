/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Task;
import model.TaskType;
import util.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class TaskView {
    private TaskController taskController = new TaskController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public void show(){
        String[] options = {"Add Task", "Delete Task", "Display Task", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Task Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        showTask();
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
    
    private void addTask(){    
        String requirementName = validationUtil.inputWithOutEmpty("Requirement Name");
                
        taskController.getTaskTypeList().forEach(System.out::println);
        int taskTypeId= validationUtil.inputIntegerInRange("Task Type",1,4);
        TaskType taskType = taskController.findTaskTypeById(taskTypeId);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        boolean flag;
        do {
            try {
                date = LocalDate.parse(validationUtil.inputWithOutEmpty("Date (dd/MM/yyyy)"), formatter);
                flag = true;
            } catch (Exception e) {
                System.out.println("Please input in format !!!");
                flag = false;
            }
        } while (!flag);
      
        float planFrom = validationUtil.inputFloatInRange("From", 0, 24);
        float planTo = validationUtil.inputFloatInRange("From", planFrom, 24);
        String assignee = validationUtil.inputWithOutEmpty("Assignee");
        String reviewer = validationUtil.inputWithOutEmpty("Reviewer");
        
        if (taskController.addNewTask(new Task(taskType, requirementName, date, planFrom, planTo, assignee, reviewer))) {
            System.out.printf("Add task name '%s' successfully !!!\n", requirementName);
        } else
            System.out.println("Add task fail !!!");
    }
    
    private void showTask(){
        List<Task> taskList = taskController.getTaskList();
        if (taskList.isEmpty()) {
            System.out.println("No task at current !!!");
        } else {
            System.out.println(String.format("| %-4s | %-12s | %-10s | %-12s | %-4s | %-10s | %-10s |", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"));
            taskList.forEach(System.out::println);
        }
    }
    
    private void removeTask(){
        int taskId = validationUtil.inputForParseInteger("Enter id task to remove");
        if (taskController.removeTask(taskId)){
            System.out.printf("Remove task with id %s susccessfully !!!\n", taskId);
        } else 
            System.out.println("Remove task fail !!!");
    }
   
}
