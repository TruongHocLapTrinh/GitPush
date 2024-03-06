/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class Task {
    private int id;
    private TaskType taskType;
    private String requirementName;
    private LocalDate date;
    private float planFrom;
    private float planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(TaskType taskType, String requirementName, LocalDate date, float planFrom, float planTo, String assignee, String reviewer) {
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(float planFrom) {
        this.planFrom = planFrom;
    }

    public float getPlanTo() {
        return planTo;
    }

    public void setPlanTo(float planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
//        return "Task{" + "id=" + id + ", taskType=" + taskType + ", requirementName=" + requirementName + ", date=" + date + ", planFrom=" + planFrom + ", planTo=" + planTo + ", assignee=" + assignee + ", reviewer=" + reviewer + '}';
        return String.format("| %-4s | %-12s | %-10s | %-12s | %-4s | %-10s | %-10s |", id, requirementName, taskType.getName(), date, (planTo - planFrom), assignee, reviewer);
    }

    

    
}
