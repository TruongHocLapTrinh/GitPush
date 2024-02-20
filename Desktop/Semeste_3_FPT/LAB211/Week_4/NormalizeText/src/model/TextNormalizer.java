/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class TextNormalizer {
    private ArrayList<INormalizable> normalizers;

    public TextNormalizer() {
        this.normalizers = new ArrayList<>();
    }

    public void addNormalizer(INormalizable normalizer) {
        this.normalizers.add(normalizer);
    }

    public String normalize(String source) {
        StringTokenizer token = new StringTokenizer(source, "\n");
        String normalized = new String();
        
        while(token.hasMoreTokens())
        {
            String line = token.nextToken().trim();
            if(line.isEmpty())
                continue;
            
            for (INormalizable normalizer : this.normalizers) {
                line = normalizer.normalize(line);
            }
            
            normalized += (line);
        }
        
        return normalized.substring(0, normalized.length() - 1); //remove \n at the end
    }
}
