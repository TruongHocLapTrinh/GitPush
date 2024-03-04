/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.AnalysisPathModel;

/**
 *
 * @author PC
 */
public class Controller {

    public String checkInputPath(String path) {
        AnalysisPathModel analysisPath = new AnalysisPathModel(path);
        return analysisPath.checkInputPath();
    }
    
}
