/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class EastAsiaCountry extends Country{
    private String countryTerrain;

    public EastAsiaCountry() {
    }

    public EastAsiaCountry(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        return super.toString() + "EastAsiaCountry{" + "countryTerrain=" + countryTerrain + '}';
    }

    @Override
    public String display() {
        return super.display() + String.format("%-10s", countryTerrain);
    }
    
    
}
