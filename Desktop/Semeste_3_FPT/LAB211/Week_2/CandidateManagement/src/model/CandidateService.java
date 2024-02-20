/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 *
 * @author PC
 */
public class CandidateService {
    
    private final static List<Candidate> candidateList = new ArrayList<>();
    
    static {
        candidateList.add(new Experience(3, "Java Spring Boots", "E-001", "Aguirre ", "Eva", 
                            1990, "Sao paulo", "940394940394 ", "eva@asante.com", 0));
        candidateList.add(new Fresher(LocalDate.of(2025, 11, 20), "Good", "FPT", "F-001", "Chau", "Dat", 2000, "Da Nang", "0905444999", "ctd@fpt.edu.vn", 1));
        candidateList.add(new Intern("software engineer", "2", "Back Khoa", "I-001", "Le", "Truong", 2003, "Quang Nam", "0901313232", "ltn@gmail.com", 2));
        
    }

    public List<Candidate> findAll(){
        return candidateList;
    }
    
    public void add(Candidate candidate) {
        candidateList.add(candidate);
    }

    public List<Candidate> searchByNameAndType(Predicate<Candidate> predicate) {
        List<Candidate> res = new ArrayList<>();
        for (Candidate candidate : candidateList) {
            if (predicate.test(candidate)) {
               res.add(candidate);
            }
        }
        return res;
    }
   
}
