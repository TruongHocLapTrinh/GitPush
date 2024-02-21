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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author PC
 */
public class PersonService {
    
    public List<Person> getPerson(String filePath, double salary){
        List<Person> res = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(";");
                double money;
                
                try {
                    money = Double.parseDouble(row[2]);
                } catch (NumberFormatException e) {
                    money = 0.0;
                }
                
                if (money < salary) {
                    continue;
                }
                String name = row[0];
                String address = row[1];
       
                Person person = new Person(name, address, money);
                res.add(person);
                sortList(res);
            }          
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public void sortList(List<Person> list){
        list.sort(new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
    }

    public void copyWordOneTimes(String source, String destination) {
        try {
            String content = readFile(source);
            
            FileWriter fileWriter = new FileWriter(destination);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }
    
    public String readFile(String source){
        String content = new String();
        try {
            FileReader fileReader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content += (line + '\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
        }

        return content;
    }
}
