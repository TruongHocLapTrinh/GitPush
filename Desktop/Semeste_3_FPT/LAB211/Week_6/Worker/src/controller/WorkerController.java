/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;
import model.History;
import model.HistoryService;
import model.Worker;
import model.WorkerService;

/**
 *
 * @author PC
 */
public class WorkerController {
    private WorkerService workerService = new WorkerService();
    private HistoryService historyService = new HistoryService();
    
    public List<History> getLogs(){
        return historyService.findAll();
    }
    
    public List<Worker> getWorkerList() {
        return workerService.findAll();
    }
    
    public void addWorker(Worker worker) {
        workerService.save(worker);
    }

    public void changeSalary(String status, String id, double salaryChange) {
        Worker worker = workerService.findWorkerByID(id);
        if (status.equals("UP")) {
            worker.setSalary(worker.getSalary() + salaryChange);
            historyService.save(new History("UP", LocalDateTime.now(), worker.getId(), worker.getName(), 
                               worker.getAge(), worker.getSalary(), worker.getWorkLocation()));
        } else {
            worker.setSalary(worker.getSalary() - salaryChange);
            historyService.save(new History("DOWN", LocalDateTime.now(), worker.getId(), worker.getName(), 
                               worker.getAge(), worker.getSalary(), worker.getWorkLocation()));
        }
    }
    
    public Worker findWorkerById(String id){
        return workerService.findWorkerByID(id);
    }

    public boolean checkWorkerID(String id) {
        return workerService.isIdExist(id);
    }

    
}
