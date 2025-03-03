// User Records Program (for 2.2 Assignment)
// Made by: Henry Smith
// Created: 2/24/2025
// Edited: 2/28/2025
// Edited: 3/2/2025
// Time Spent: Around 16 hours

import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;


// NOTE: The first part of the program is taken from a program I made previously (StudentFileWriter.java)

// NOTE FOR TEACHER: I am not entirley certain if these two programs need to be in their own seperate files for full credit on the assignment, so let me know if you would like me to do so!

public class UserRecords {
    public static void main(String[] args) {

        // Creates the variables of the program
        int UserNum = 1;
        String iFilePath = "inputrecords.txt";
        String delimiters = ";";
        int ageSum = 0;
        int otherLoopTimer = 0;
        float aFavNumber = 0;
        float sFavNumber = 0;
        int iAge = 0;
        int iFavoriteN = 0;
        Scanner Userinput = new Scanner(System.in);

            // EXTRA CODE: Tells the user the program is running
            System.out.println(" ");
            System.out.println("File Writer Program Running...");
            System.out.println(" ");

            // Seperates the
            try (BufferedWriter introWriter = new BufferedWriter(new FileWriter(iFilePath, true))) {
                introWriter.newLine();
            }   catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        
        // Repeats the user input questions a total of 5 times
        for (int x = 0; x <= 4; x++) {
            // Displays the number of the user
            System.out.println("----------------------------");
            System.out.println("Hello, User "+ UserNum + "! Please insert the desired input below!");
            
            // Asks for the user's name
            System.out.println(" ");
            System.out.println("Insert First and Last Name:");
            String iName = Userinput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
        
            // Asks for the user's Age
            System.out.println("Insert Age:");
            try {
                iAge = Userinput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, Please Insert an Integer with 3 digits or less");
                Userinput.next();
                Userinput.close();
            }
            
            System.out.println("Input Accepted");
            System.out.println(" ");
        
            // Asks for the user's favorite color
            System.out.println("Insert Favorite Color:");
            String Empty1 = Userinput.nextLine(); // <--- Used to fix an odd input bug that occurs
            String iFavoriteC = Userinput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
        
            // Asks for the user's favorite 4-digit number
            System.out.println("Insert Favorite 4-Digit Number");
            try {
                iFavoriteN = Userinput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, Please Insert a 4 digit Integer");
                Userinput.next();
                Userinput.close();
            }
            System.out.println("Input Accepted");                
            System.out.println(" ");

            // Asks for the user's first intial
            System.out.println("Insert Your Middle Initial (1 Letter):");
            String Empty2 = Userinput.nextLine(); // <--- Used to fix an odd input bug that occurs
            String iInitial = Userinput.nextLine();
            System.out.println("Input Accepted");                
            System.out.println(" ");            
        
            // EXTRA CODE: lets the user know it is adding the collected inputs to the selected file
            System.out.print(Empty1 + Empty2);
            System.out.println(" ");
            System.out.println( "Adding Inputs to new file. . ."); 
                // Edits the file called "inputrecords.txt", and converts the collected inputs into bytes that are then transfered to the "inputrecords.txt" file
                try (BufferedWriter inputWriter = new BufferedWriter(new FileWriter(iFilePath, true))) {
                    String lineInput = "User " + UserNum + " Inputs: ;" + iName + ";" + iInitial + ";" + iAge + ";" + iFavoriteC + ";" + iFavoriteN + ";";
                    inputWriter.newLine();
                    inputWriter.write(lineInput);
                }   catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }

            System.out.println(" ");
            System.out.println("Initialising Next User...");

                UserNum +=1 ;
            } 

        Userinput.close();

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("File Reader Program Running...");
        System.out.println(" ");
        System.out.println("Reading selected file... ");
        System.out.println(" ");
        System.out.println("Calculating Average Favorite Number and Total Age Sum...");
        System.out.println(" ");

        // Reads the file created earlier and tokenizes it
        try (BufferedReader FileR = new BufferedReader(new FileReader(iFilePath)))  {
            String text;
            while ((text = FileR.readLine()) != null)   {
                StringTokenizer tokenMaker = new StringTokenizer(text, delimiters);

                while (tokenMaker.hasMoreTokens()) {
                    String token = tokenMaker.nextToken();

                    // Checks to see if the current token is the age input from earlier
                    try {
                        if (token.length() <= 3) {
                        int age = Integer.parseInt(token);
                        ageSum += age;
                        } else {
                            int favnum = Integer.parseInt(token);
                            sFavNumber += favnum;
                            float numberSumCopy = sFavNumber;
                            String nValue = String.valueOf(sFavNumber);
                            aFavNumber = (numberSumCopy / nValue.length());
                        }
                    }   catch (NumberFormatException e1) {
                          
                    }
                }
            }
        }   catch (IOException e) {
            System.err.println("File Reading Error " + e.getMessage());
        }

        // Reads the file and tokenizes it a second time, so that the text from the file can be printed out.
        System.out.println("Successfully calculated Average Favorite Number and Total Age Sum!"); 
        System.out.println(" "); 
        System.out.println("Now printing the info from [inputrecords.txt]..."); 
        System.out.println(" "); 
        System.out.println("-------INPUT RECORDS-------");
        System.out.println(" "); 
        System.out.println("Example Input:  NAME INITIAL AGE COLOR FAVORITE_4_DIGIT_NUMBER");
        System.out.println(" ");
            // Reads the inputrecord.txt file
            try (BufferedReader FileR = new BufferedReader(new FileReader(iFilePath)))  {
                String newText;
                while ((newText = FileR.readLine()) != null)   {
                    StringTokenizer nTokenMaker = new StringTokenizer(newText, delimiters);
                    while (nTokenMaker.hasMoreTokens()) {
                        String newToken = nTokenMaker.nextToken();
                        System.out.print(newToken + " / ");
                        otherLoopTimer += 1;

                        if (otherLoopTimer == 6) {
                            System.out.println(" ");
                            otherLoopTimer -= 6;
                        }

                    }
                }
            }   catch (IOException e) {
                System.err.println("File Reading Error " + e.getMessage());
            }   
            
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Average Favorite 4-Digit Number (Excluding Decimal): " + aFavNumber + " Total Age Sum: " + ageSum);
        
        // Seperates the previous input records from any new inputs that might be recorded later (when the program is run a 2nd time without clearing the file)
        try (BufferedWriter inputWriter2 = new BufferedWriter(new FileWriter(iFilePath, true))) {
            inputWriter2.newLine();
        }   catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // EXTRA CODE: Tells the user the program is finished
        System.out.println(" ");       
        System.out.println("Program Finished");
        System.out.println(" ");      
               
    }
}

/*  (ANOTHER) NOTE FOR TEACHER: Sorry that I left a bunch of code down here last time, my bad!
    I just had the code down here for testing purposes, and I usually delete it afterwards. 

    Also, I am unsure as to why the code from the previous assignment didn't work when downloaded from GitHub, since I had tested it multiple times, and every time it worked as intended.

    And one more thing, I hadn't added the second part of the code because I believed that in the instructions it said that the second part would be due next week. Only after
    re-reading the instructions about three times did I notice that the sentence "but I want you to start on it this week" was reffering to the second part, and not
    the overall assignment. Sorry about that!


*/