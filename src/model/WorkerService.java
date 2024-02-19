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
public class WorkerService {
    
    private final static List<Worker> workerList;
    
    static {
        workerList = new ArrayList<>();
        workerList.add(new Worker("W1", "DAT", 23, 1000, "Da Nang"));
        workerList.add(new Worker("W2", "QUOC", 21, 2000, "QUANG NAM"));
        workerList.add(new Worker("W3", "TRUONG", 20, 3000, "DIEN BAN"));
    }
    
    public List<Worker> findAll(){
        return workerList;
    }

    public void save(Worker worker) {
        workerList.add(worker);
    }

    public Worker findWorkerByID(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        throw new RuntimeException();
    }
    
    public boolean isIdExist(String id){
        for (Worker worker : workerList) {
            if (worker.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
