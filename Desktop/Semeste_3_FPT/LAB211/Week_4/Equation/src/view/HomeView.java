package view;

import controller.HomeController;

import java.util.Scanner;

public class HomeView {
    private HomeController homeController;

    public HomeView(HomeController homeController) {
        this.homeController = homeController;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
        Menu<String> homeMenu = new Menu<>("Equation Program", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        homeController.solveSuperlativeEquation();
                        break;
                    case 2:
                        homeController.solveQuadraticEquation();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        };
        homeMenu.run();
    }
}
