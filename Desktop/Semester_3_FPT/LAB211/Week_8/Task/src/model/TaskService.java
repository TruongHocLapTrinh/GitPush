/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TaskService {
    private final static List<Task> taskList = new ArrayList<>();
    
    public List<Task> findAll(){
        return taskList;
    }
    
    public boolean save(Task task) {
        int lastId = 0;
        if(!taskList.isEmpty()){
            lastId = taskList.get(taskList.size() - 1).getId();
        }
        task.setId(lastId + 1);
        return taskList.add(task);
    }

    public boolean removeTask(int taskId) {
        return taskList.removeIf(e -> e.getId() == taskId);
    }
    
}
