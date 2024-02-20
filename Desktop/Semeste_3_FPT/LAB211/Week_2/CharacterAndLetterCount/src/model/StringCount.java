/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class StringCount {
    
    private final HashMap<String, Integer> wordCountMap;
    private final HashMap<Character, Integer> charCountMap;

    public StringCount() {
        wordCountMap = new HashMap<>();
        charCountMap = new HashMap<>();
    }
    
    
    public void countWord(String string){
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            if (wordCountMap.containsKey(nextToken)) {
               wordCountMap.put(nextToken, wordCountMap.get(nextToken) + 1);
            } else
                wordCountMap.put(nextToken, 1);
        }
    
    }
    
    public void countCharacter(String string){
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            for (Character c : nextToken.toCharArray()) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else
                    charCountMap.put(c,1);
            }
        }
        
    }
    
    public void display(){
        System.out.println(wordCountMap);
        System.out.println(charCountMap);
    }
    
    
}
