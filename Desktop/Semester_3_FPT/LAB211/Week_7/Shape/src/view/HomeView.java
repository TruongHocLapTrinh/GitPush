/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CalculatorShapeController;
import util.Menu;
import util.ValidationUtil;

/**
 *
 * @author PC
 */
public class HomeView {

    private ValidationUtil validationUtil = new ValidationUtil();
    private CalculatorShapeController csc = new CalculatorShapeController();
    
    public void show(){
       
        String[] options = {"Circle", "Triangle", "Rectangle", "Exit"};
        Menu<String> homeMenu = new Menu<String>("Calculator Shape Program", options) {
            @Override
            public void execute(int choice) {
                String result;
                switch (choice) {
                    case 1:
                        double radius = validationUtil.inputDoubleGreaterThan("Please input radius of Circle", 0);
                        result = csc.getResultCircle(radius);
                        System.out.println(result);
                        break;
                    case 2:
                        double a = validationUtil.inputDoubleGreaterThan("Please input side A of Triangle", 0);
                        double b = validationUtil.inputDoubleGreaterThan("Please input side B of Triangle", 0);
                        double c = validationUtil.inputDoubleGreaterThan("Please input side C of Triangle", 0);
                        result = csc.getResultTriangle(a,b,c);
                        System.out.println(result);
                        break;
                    case 3:
                        double width = validationUtil.inputDoubleGreaterThan("Please input width of Rectangle", 0);
                        double length = validationUtil.inputDoubleGreaterThan("Please input length of Rectangle", 0);
                        result = csc.getResultRectangle(width, length);
                        System.out.println(result);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice !!!");
                }
            }
        };
        homeMenu.run();
    }
}
