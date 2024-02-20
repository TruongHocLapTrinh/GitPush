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
public class UppercaseFirstCharOfSentenceNormalizer implements INormalizable{
    @Override
    public String normalize(String source) {
        String normalized = new String();

        StringTokenizer tokenizer = new StringTokenizer(source, ".");

        while (tokenizer.hasMoreTokens()) {
            String sentence = tokenizer.nextToken().trim().toLowerCase();

            if(sentence.isEmpty())
                continue;
            
            normalized += (". " + Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1));
        }

        return normalized.substring(2); //remove ". " at the first
    }
}
