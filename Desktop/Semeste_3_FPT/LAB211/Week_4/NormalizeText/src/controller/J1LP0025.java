/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.TextNormalizer;
import service.DotAtTheEndNormalizer;
import service.NoSpaceInQuoteNormalizer;
import service.OnlySpaceAfterMarkNormalizer;
import service.OnlySpaceBetweenMarkNormalizer;
import service.OnlySpaceBetweenWordsNormalizer;
import service.UppercaseFirstCharOfSentenceNormalizer;

/**
 *
 * @author PC
 */
public class J1LP0025 {
    
    public static String readFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String content = new String();
        String line;

        while ((line = reader.readLine()) != null) {
            content += (line + '\n');
        }

        return content.substring(0, content.length() - 1); //remove \n at the end
    }

    /**
     * write to file
     * @param content written content
     * @param filename filename of written file
     * @throws java.io.IOException
     */
    public static void writeFile(String content, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextNormalizer normalizer = new TextNormalizer();
        
        normalizer.addNormalizer(new OnlySpaceBetweenWordsNormalizer());
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(","));
        normalizer.addNormalizer(new OnlySpaceAfterMarkNormalizer(":"));
        normalizer.addNormalizer(new UppercaseFirstCharOfSentenceNormalizer());
        //This also include same function with OnlySpaceBetweenMarkNormalizer(".")
        normalizer.addNormalizer(new DotAtTheEndNormalizer());
        normalizer.addNormalizer(new OnlySpaceBetweenMarkNormalizer("\""));
        normalizer.addNormalizer(new NoSpaceInQuoteNormalizer());
        
        String content = null;
        
        System.out.print("READING input.txt...");
        try {
            content = readFile("input.txt");
        } catch (IOException ex) {
            System.out.println("FAIL");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");
        
        System.out.print("NORMALIZING CONTENT...");
        String normalized = normalizer.normalize(content);
        System.out.println("DONE");

        System.out.println("WRITING CONTENT TO output.txt");
        try {
            writeFile(normalized, "output.txt");
        } catch (IOException ex) {
            System.out.println("FAIL.");
            System.out.println("ERROR: " + ex.getMessage());
            System.exit(0);
        }
        System.out.println("DONE");
    }
    
}
