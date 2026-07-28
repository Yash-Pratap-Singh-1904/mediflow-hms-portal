package com.hms.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLIUtils {
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Invalid numeric input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Invalid numeric input. Please enter a double value.");
                scanner.nextLine();
            }
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}