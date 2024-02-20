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
public class NoSpaceInQuoteNormalizer implements INormalizable{

    private final char QUOTE_MARK = '\"';

    @Override
    public String normalize(String source) {
        String normalized = new String();

        String line = source;

        while (true) {
            int headQuoteIndex = line.indexOf(this.QUOTE_MARK);

            if (headQuoteIndex == -1) //not found
            {
                normalized += (line);
                return normalized;
            }

            normalized += line.substring(0, headQuoteIndex + 1);

            line = line.substring(headQuoteIndex + 1);
            int tailQuoteIndex = line.indexOf(this.QUOTE_MARK);
            tailQuoteIndex = (tailQuoteIndex != -1) ? tailQuoteIndex : line.length();

            normalized += (line.substring(0, tailQuoteIndex).trim() + this.QUOTE_MARK);

            line = line.substring(tailQuoteIndex);

            if (line.isEmpty()) {
                break;
            }
            
            line = line.substring(1); //remove the QUOTE of tail

        }

        return normalized; //remove the QUOTE_MARK at the end
    }
    
    
}
