/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.INormalizable;

/**
 *
 * @author PC
 */
public class DotAtTheEndNormalizer implements INormalizable{

    @Override
    public String normalize(String source) {
        char lastChar = source.charAt(source.length() - 1);
        
        if(lastChar == '.')
            return source;
        
        return source + ".";
    }
    
}
