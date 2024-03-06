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
public class TaskTypeService {
    private final static List<TaskType> taskTypeList = new ArrayList<>();
    static {
        taskTypeList.add(new TaskType(1, "Code"));
        taskTypeList.add(new TaskType(2, "Test"));
        taskTypeList.add(new TaskType(3, "Design"));
        taskTypeList.add(new TaskType(4, "Review"));
        
    }
    
    public List<TaskType> findAll(){
        return taskTypeList;
    }

    public TaskType getTaskTypeById(int taskTypeId) {
        for (TaskType taskType : taskTypeList) {
            if (taskTypeId == taskType.getId()) {
                return taskType;
            }
        }
        throw new RuntimeException("Task Type ID does not exist !!!");
    }
}
