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
public class HistoryService {
    
    private final static List<History> logs;
    
    static {
        logs = new ArrayList<>();
    }
    
    public List<History> findAll(){
        return logs;
    }

    public void save(History history) {
        logs.add(history);
    }
}
