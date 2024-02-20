/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Util.ValidationUtil;
import controller.CountryController;
import model.EastAsiaCountry;

/**
 *
 * @author PC
 */
public class CountryView {
//    private CountryController countryController = new CountryController();
    private ValidationUtil validationUtil = new ValidationUtil();
    
    public CountryController getController(){
        return new CountryController();
    }
    
    public void showAddCountryForm() {
        String countryCode = validationUtil.inputWithOutEmpty("Enter code of country");
        String countryName = validationUtil.inputWithOutEmpty("Enter name of country");
        float totalArea = validationUtil.inputForArea("Enter total area");
        String countryTerrain = validationUtil.inputWithOutEmpty("Enter terrain of country");
        getController().addCountry(new EastAsiaCountry(countryTerrain,countryCode,countryName,totalArea));
    }

    public void searchCountryByName() {
        String countryName = validationUtil.inputWithOutEmpty("Enter name of country");
        System.out.println("Info about countries contains " + countryName);
        System.out.println(getController().searchCountryByName(countryName));
    }
    
}
