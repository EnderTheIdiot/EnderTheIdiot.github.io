// Scanner Input Class
// Made by Henry Smith
// For Software and Programming Dev 2 Class
// Project Started: Jan 17 2025
// Project Finished: Jan 17 2025

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Outputs a line of text informing the user the system it ready
            System.out.println("- ScannerClass is now running -");

        // Outputs a prompt asking the user to input any number
            System.out.println("----------------------------");
            System.out.println("Insert any number");
            int integerInput = scanner.nextInt();
            System.out.println("Input Accepted");
            System.out.println("----------------------------");

        // Outputs a prompt asking the user to input any number with any two decimals
            System.out.println("Insert any number with any amount decimals");
            float floatInput = scanner.nextFloat();
            System.out.println("Input Accepted");
            System.out.println("----------------------------");

        // Scans the line of text that will be inserted later 
            scanner.nextLine();

        // Outputs a prompt asking the user to input any line of text
            System.out.println("Insert any line of text");
            String lineInput = scanner.nextLine();
            System.out.println("Input Accepted");
            System.out.println("----------------------------");
        
        // Outputs a line of text showing the recevied inputs of the scanner
            System.out.println("Your Inputs:");
            System.out.println("Input 1 = " + integerInput);
            System.out.println("Input 2 = " + floatInput);
            System.out.println("Input 3 = " + lineInput);
            System.out.println("----------------------------");

            scanner.close();
    }
}

/* NOTICE: I would like to explain that this command:

    "System.out.println("----------------------------");"

    is used for visual purposes, and are not needed.
*/