/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Task;
import model.TaskService;
import model.TaskType;
import model.TaskTypeService;

/**
 *
 * @author PC
 */
public class TaskController {
    private TaskService taskService = new TaskService();
    private TaskTypeService taskTypeService = new TaskTypeService();

    public TaskType findTaskTypeById(int taskTypeId) {
        return taskTypeService.getTaskTypeById(taskTypeId);
    }

    public boolean addNewTask(Task task) {
        return taskService.save(task);
    }

    public List<Task> getTaskList() {
        return taskService.findAll();
    }

    public boolean removeTask(int taskId) {
        return taskService.removeTask(taskId); 
   }

    public List<TaskType> getTaskTypeList() {
        return taskTypeService.findAll();
    }
    
}
