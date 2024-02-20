/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author PC
 */
public class CountryService {
    private final static List<Country> countryList;
    static {
        countryList  = new ArrayList<>();
        countryList.add(new EastAsiaCountry("K-POP", "KOR", "Korean", 7));
        countryList.add(new EastAsiaCountry("Bad", "CN", "China", 10));
        countryList.add(new EastAsiaCountry("Sakura", "JP", "Japan", 5));
    }
    
    public List<Country> findAll(){
        return countryList;
    }

    public void save(EastAsiaCountry eastAsiaCountry) {
        countryList.add(eastAsiaCountry);
    }

    public List<Country> findByName(Predicate<Country> p) {
        List<Country> res = new ArrayList<>();
        for (Country c : res) {
            if (p.test(c)) {
                res.add(c);
            }
        }
        return res;
    }
}
