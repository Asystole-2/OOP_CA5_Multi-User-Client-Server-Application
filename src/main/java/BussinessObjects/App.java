package BussinessObjects;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menuOptions menu = new menuOptions();
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                menu.menuOptions();
                int choice = Integer.parseInt(in.nextLine());
                switch (choice) {
                    case 1 -> System.out.print("method for all entities here \n");
                    case 2 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

}
