/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Circle extends Shape{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public String getResult() {
        return String.format("""
                             ---------- Circle ----------
                             Radius    : %.2f 
                             Area      : %.2f 
                             Perimeter : %.2f 
                             """, radius, getArea(), getPerimeter());
    }
    
    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }
}
