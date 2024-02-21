/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();
    private final String FILE_PATH = "dictionary.txt";

    public Dictionary() {
        readCSV();
    }
    
    
    
    public void addWord(String eng, String vi) {
        dictionary.put(eng, vi);
        writeToCSV();
    }

    public void removeWord(String eng) {
        dictionary.remove(eng);
        writeToCSV();
    }

    public String translateWord(String eng) {
        return dictionary.get(eng);
    }
    
    private void readCSV(){
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new  BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] row = line.split("-");
                dictionary.put(row[0], row[1]);
            }
                  
        } catch (IOException e) {
            System.out.println("File can not read !!!");
        }
    }
    
    private void writeToCSV(){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (String key : dictionary.keySet()) {
                bufferedWriter.write(key + "-" + dictionary.get(key) + '\n');
            }
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }

    public boolean checkKey(String eng) {
        return dictionary.containsKey(eng);
    }
}
