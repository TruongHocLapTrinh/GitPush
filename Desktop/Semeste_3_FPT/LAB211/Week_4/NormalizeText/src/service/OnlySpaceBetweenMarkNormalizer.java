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
public class OnlySpaceBetweenMarkNormalizer implements INormalizable{
    private String mark;

    public OnlySpaceBetweenMarkNormalizer(String mark) {
        this.mark = mark;
    }

    @Override
    public String normalize(String source) {
        String normalized = new String();

        StringTokenizer tokenizer = new StringTokenizer(source, this.mark);

        while (tokenizer.hasMoreTokens()) {
            normalized += (tokenizer.nextToken().trim() + " " + this.mark + " ");
        }

        return normalized.substring(0, normalized.length() - 2); //remove this.mark + ' ' at the end of line
    }
}
