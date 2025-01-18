// Scanner Input Class
// Made by Henry Smith
// For Software and Programming Dev 2 Class
// Project Started: Jan 17 2025
// Project Finished: Jan 17 2025

import java.util.Scanner;

public class ScannerClass2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Outputs a line of text informing the user the system it ready
            System.out.println(" ");
            System.out.println("- The System is now running -");

            // Is used to delay the next command by 2000 milliseconds
                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }
                
        // Outputs a basic fake loading text

            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Preparing System Prompts");
            
                try {
                    Thread.sleep(1000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }

                System.out.print(".");
                try {
                    Thread.sleep(1000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }
                System.out.print(" .");
                try {
                    Thread.sleep(1000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }
                System.out.print(" .");
                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }

                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Welcome User");
                System.out.println("----------------------------");

                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }

        // Outputs a prompt asking the user to input any line of text
        System.out.println("Insert Username (Your Name or Nickname)");

        // Outputs a prompt asking the user to input any line of text
            String lineInput = scanner.nextLine();
            System.out.println(" ");
            System.out.println("Input Accepted");
            System.out.println("----------------------------");
    
                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }

        // Outputs a prompt asking the user to input any number
            System.out.println("Insert Favorite Number (Without Decimals)");
            int integerInput = scanner.nextInt();
            System.out.println(" ");
            System.out.println("Input Accepted");
            System.out.println("----------------------------");

                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }

        // Scans the line of text that will be inserted later 
            scanner.nextLine();

        // Outputs a prompt asking the user to input any line of text
            System.out.println("Insert a user discription (This can be anything you wish, even a single word if you wish)");
            String lineInput2 = scanner.nextLine();
            System.out.println(" ");
            System.out.println("Input Accepted");
            System.out.println("----------------------------");


                try {
                    Thread.sleep(2000);
                }   catch (InterruptedException e)  {
                    e.printStackTrace();
                }
        
        // Outputs a line of text showing the recevied inputs of the scanner
            System.out.println("Your Inputs:");
            System.out.println("Username = " + lineInput);
            System.out.println("Favorite Number = " + integerInput);
            System.out.println("User Discription = " + lineInput2);
            System.out.println("----------------------------");
            
            System.out.println("- System close -");
            System.out.println(" ");

            scanner.close();
    }
}

/* NOTICE: This is the second version of my scanner class that work like an old analog machine (cause I think it would be fun to make that)
    the previous version of the scanner class is the one made for the actaul assignment!
*/