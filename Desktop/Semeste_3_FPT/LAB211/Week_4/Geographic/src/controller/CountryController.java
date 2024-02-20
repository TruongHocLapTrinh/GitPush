/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Country;
import model.CountryService;
import model.EastAsiaCountry;

/**
 *
 * @author PC
 */
public class CountryController {
    private CountryService countryService = new CountryService();
    
    public void addCountry(EastAsiaCountry eastAsiaCountry){
        countryService.save(eastAsiaCountry);
    }

    public List<Country> findAll() {
        return countryService.findAll();
    }

    public List<Country> searchCountryByName(String name) {
        return countryService.findByName((Country c)-> c.getCountryName().contains(name));
    }

    
    
}
