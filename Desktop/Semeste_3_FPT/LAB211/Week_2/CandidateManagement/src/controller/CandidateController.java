/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Util.ValidationUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.CandidateService;

/**
 *
 * @author PC
 */
public class CandidateController {
    
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final CandidateService candidateService = new CandidateService();

    public void createCandidate(int candidate_type) {
        String candidate_id = validationUtil.inputWithOutEmpty("Candidate ID");
        String firstName = validationUtil.inputWithOutEmpty("First name");
        String lastName = validationUtil.inputWithOutEmpty("Last name");
        int birthdate = validationUtil.inputYearOfBirth("Year of birth");
        String address = validationUtil.inputWithOutEmpty("Address");
        String phone = validationUtil.inputPhoneWithMin10Char("Phone");
        String email = validationUtil.inputMail("Email");
        
        switch (candidate_type) {
            case 0 -> {
                int expInYear = validationUtil.inputYearOfExp("Year of experience");
                String ProSkill = validationUtil.inputWithOutEmpty("Professtional skill");
                Experience experience = new Experience(expInYear, ProSkill, candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
                candidateService.add(experience);
            }
            case 1 -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate graduation_date =  LocalDate.parse(validationUtil.inputWithOutEmpty("Graduation_date (dd/MM/yyyy)"), formatter);
                String graduation_rank = validationUtil.inputGraduationRank("Graduation rank (Excellence/ Good/ Fair/ Poor)");   // 4 value : Excellence, Good, Fair, Poor
                String education = validationUtil.inputWithOutEmpty("University name");
                Fresher fresher = new Fresher(graduation_date, graduation_rank, education, candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
                candidateService.add(fresher);
            }
            case 2 -> {
                String major = validationUtil.inputWithOutEmpty("Major");
                String semester = validationUtil.inputWithOutEmpty("Semester");
                String university_name = validationUtil.inputWithOutEmpty("University name");
                Intern intern = new Intern(major, semester, university_name, candidate_id, firstName, lastName, birthdate, address, phone, email, candidate_type);
                candidateService.add(intern);
            }
        }
        
        
    }

    public void searchCandidate() {
        displayCandidate();
        
        String name = validationUtil.inputWithOutEmpty("Name (First Name or Last Name)");
        int candidate_type = validationUtil.inputCandidateTypeFrom0to2("Candidate type(0: Experience | 1: Fresher | 2: Intern)");
        
        List<Candidate> searchList = candidateService.searchByNameAndType((Candidate p)-> 
                p.getFirstName().trim().contains(name) || p.getLastName().trim().contains(name)
                        && p.getCandidate_type() == candidate_type);
        
        System.out.println("");
        if (searchList.isEmpty()) {
            System.out.printf("No info about %s in related to type %s \n\n", name, candidate_type);
        } else {
            System.out.println("The candidates found :");
            for (Candidate candidate : searchList) {
                System.out.println(candidate.getInfo());
            }
        }
       
        
    }
    
    
    public void displayCandidate(){
        List<Candidate> candidateList = candidateService.findAll();

        System.out.println("===========EXPERIENCE CANDIDATE===========");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("");
        
        System.out.println("===========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("");
        
        System.out.println("===========INTERN CANDIDATE===============");
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("");
        
    }
    
}
