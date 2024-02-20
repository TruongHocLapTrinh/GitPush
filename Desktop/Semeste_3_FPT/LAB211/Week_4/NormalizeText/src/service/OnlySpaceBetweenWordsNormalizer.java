/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.StringTokenizer;
import model.INormalizable;

/**
 *
 * @author PC
 */
public class OnlySpaceBetweenWordsNormalizer implements INormalizable{
    @Override
    public String normalize(String source) {
        String normalized = new String();
        StringTokenizer tokenizer = new StringTokenizer(source, " \t");

        while (tokenizer.hasMoreTokens()) {
            normalized += tokenizer.nextToken() + ' ';
        }
        
        return normalized.substring(0, normalized.length() - 1); //remove the last space
    }
}
