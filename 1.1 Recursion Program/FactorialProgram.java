// Program Name: Simple Factorial Recursion Program 
// Made by: Henry Smith
// Created: Jan 16, 2026

import java.util.Scanner;

public class FactorialProgram {

    // Finds the factorial of the number 
    public static long findFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * findFactorial(n-1);
        }
    }

    public static void main(String[] args) {
        // Start-up messages
        System.out.println(" ");
        System.out.println("Program Online");
        System.out.println("Type a number to get its factorial, and type /close to close the program.");
        Scanner userInput = new Scanner(System.in);
        int numberInput;

        // Obtains the number from the user's input, finds it's factorial, and prints it out
        if (userInput.hasNextInt()) {
            numberInput = userInput.nextInt();
            long results = findFactorial(numberInput);
            System.out.println("Factorial of " + numberInput + " = " + results);
        }

        userInput.close();
    }
    

    
}
