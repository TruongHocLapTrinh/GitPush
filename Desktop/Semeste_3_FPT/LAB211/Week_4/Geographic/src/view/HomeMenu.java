/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CountryController;
import java.util.Comparator;
import java.util.List;
import model.Country;
import model.Menu;

/**
 *
 * @author PC
 */
public class HomeMenu {

    private CountryView countryView = new CountryView();
//    private CountryController countryController = new CountryController();
    
    public CountryController getController(){
        return new CountryController();
    }
    
    public void show(){
        
        String[] options = {"Enter the information for 11 countries in Southeast Asia.",
                            "Display already information.", 
                            "Search the country according to the entered country's name.",
                            "Display the information increasing with the country name.",
                            "Exit"};
        
        Menu<String> homeMenu = new Menu<String>("Manage East Asia Countries", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        countryView.showAddCountryForm();
                        System.out.println("Add Successfully !!!");
                        break;
                    case 2:
                        List<Country> res = getController().findAll();
                        System.out.println(res.get(res.size()-1).display());
                        break;
                    case 3:
                        countryView.searchCountryByName();
                        break;
                    case 4:
                        List<Country> sortList = getController().findAll();
                        sortList.sort((Country o1, Country o2) -> o1.getCountryName().compareTo(o2.getCountryName()));
                        System.out.printf("%-10s %-12s %-15s %-10s \n", "ID", "Name", "Total Area", "Terrain");
                        for (Country country : sortList) {
                            System.out.println(country.display());
                        }
                        break;
                    case 5:
                        System.exit(0);
                   
                }
            }
        };
        homeMenu.run();
    }
    
}
