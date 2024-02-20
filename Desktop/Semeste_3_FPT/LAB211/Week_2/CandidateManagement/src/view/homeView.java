/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CandidateController;
import model.Menu;

/**
 *
 * @author PC
 */
public class homeView {
    
    private final CandidateController candidateController = new CandidateController();
    
    public void show(){
        String[] options = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
        Menu<String> homeView = new Menu<String>("CANDIDATE MANAGEMENT SYSTEM", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        candidateController.createCandidate(0);
                        break;
                    case 2:
                        candidateController.createCandidate(1);
                        break;
                    case 3:
                        candidateController.createCandidate(2);
                        break;
                    case 4:
                        candidateController.searchCandidate();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            }       
        };
        homeView.run();
    }
}
