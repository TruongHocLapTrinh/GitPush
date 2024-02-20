/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class History extends Worker{
    private String status;
    private LocalDateTime date;

    public History() {
    }

    public History(String status, LocalDateTime date, String id, String name, int age, double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %-6s | %12s |", status, date);
//                "History{" + "status=" + status + ", date=" + date + '}';S
    }
       
    
}
