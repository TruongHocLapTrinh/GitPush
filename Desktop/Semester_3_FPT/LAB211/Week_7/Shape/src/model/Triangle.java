/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public boolean isTriangle(){
        return (a + b > c && a + c > b && b + c > a);
    }
    
    @Override
    public double getPerimeter() {
        return (a + b + c);
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public String getResult() {
        return String.format("""
                             ---------- Triangle ----------
                             Side A    : %.2f
                             Side B    : %.2f
                             Side C    : %.2f
                             Area      : %.2f
                             Perimeter : %.2f
                             """, a, b, c, getArea(), getPerimeter());
    }
    
}
