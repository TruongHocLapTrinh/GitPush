/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author PC
 */
public class CalculatorShapeController {

    public String getResultCircle(double radius) {
        return new Circle(radius).getResult();
    }

    public String getResultTriangle(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        if (!triangle.isTriangle()) {
            return "It is not triangle !!!";
        }
        return triangle.getResult();
    }

    public String getResultRectangle(double width, double length) {
        return new Rectangle(width, length).getResult();
    }
    
}
