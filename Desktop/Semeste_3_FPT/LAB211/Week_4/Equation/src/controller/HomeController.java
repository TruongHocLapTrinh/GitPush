package controller;

import model.SuperlativeEquation;
import model.QuadraticEquation;
import view.HomeView;

public class HomeController {
    private SuperlativeEquation superlativeEquation;
    private QuadraticEquation quadraticEquation;
    private HomeView homeView;

    public HomeController() {
        this.superlativeEquation = new SuperlativeEquation();
        this.quadraticEquation = new QuadraticEquation();
        this.homeView = new HomeView(this);
    }

    public void start() {
        homeView.show();
    }

    public void solveSuperlativeEquation() {
        superlativeEquation.solveSuperlativeEquation();
    }

    public void solveQuadraticEquation() {
        quadraticEquation.solveQuadraticEquation();
    }

    public static void main(String[] args) {
        new HomeController().start();
    }
}
