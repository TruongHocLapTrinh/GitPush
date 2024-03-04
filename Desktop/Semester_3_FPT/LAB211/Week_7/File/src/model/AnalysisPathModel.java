/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;

/**
 *
 * @author PC
 */
public class AnalysisPathModel {
    
    private String path;

    public AnalysisPathModel() {
    }
    
    public AnalysisPathModel(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
    public String checkInputPath() {

//        path = checkInputString(path);
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return String.format("""
                                 Disk : %s
                                 Extension : %s
                                 File name : %s
                                 Path : %s
                                 Folder : [%s]
                                 """, 
                    getDisk(path), getExtension(path), getFileName(path), getPath(path), getForder(path));
      
        } else {
            return "Path isn't file.";
        }
    }

    public String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk + 1, toNameFile);
    }

    public String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    public String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot, path.length());
    }

    private String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon + 1);
    }

    private String getForder(String path) {
        int positionColon = path.indexOf("\\");
        int positionDot = path.lastIndexOf("\\");
        path = path.substring(positionColon, positionDot);
        String[] splitFile = path.split("\\\\");
        return splitFile[splitFile.length - 1];
    }
}
