// File Reader/Tokenizer Program ( Part of Assignment 2.1 )
// Made by: Henry Smith
// Created: 2/11/2025
// Edited: 2/11/2025

// NOTE: I have it so that the program doesn't print out the type names on the list ("Letter" "Frequency" "Percentage"), but let me know if it does need to include them

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LetterFreqReader {
    public static void main(String[] args) {

        String iFilePath = "letter_frequency.txt";
        String delimiters = ", ";
        float percentS = 0;
        int freqA = 0;
        int freqS = 0;

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("Program Running...");
        System.out.println(" ");
        System.out.println("Printing list of letter frequencies...");
        System.out.println(" ");
        System.out.println("LETTER FREQUENCIES");
        System.out.println("----------------------------");

        // Reads the file using a buffered reader, and converts every word/number into a token  (NOTE: Some of this code was carried over from one of my previous assingments)
        try (BufferedReader FileR = new BufferedReader(new FileReader(iFilePath)))  {
            String text;
            while ((text = FileR.readLine()) != null)   {
                StringTokenizer tokenMaker = new StringTokenizer(text, delimiters);

                while (tokenMaker.hasMoreTokens()) {
                    String token = tokenMaker.nextToken();

                    // Checks to see if the token is an integer, and prints it out as one if it is
                    try {
                        int freq = Integer.parseInt(token);
                        System.out.println("Frequency = " + freq);
                        freqS += freq;
                        int freqSum = freqS;
                        freqA = (freqSum / token.length());

                    }   catch (NumberFormatException e1) {

                        // Checks to see if the token is an float, and prints it out as one if it is
                        try {
                            float percent = Float.parseFloat(token);
                            System.out.println("Percent = " + percent);
                            System.out.println(" ");
                            percentS += percent;
                        }   catch (NumberFormatException e2) {
                            
                            // Checks to see if the token is 1 letter long (technically 3 if including the " marks). and prints it out if it is
                            try {
                                if (token.length() == 3) {
                                System.out.println("Letter = " + token);
                                } else {
                                System.out.print("");
                                }
                            }   catch (NumberFormatException e3) {

                            }

                        }
                    }
                }
            }
        }   catch (IOException e) {
            System.err.println("File Reading Error " + e.getMessage());
        }

        // EXTRA CODE: Tells the user the program is finished
        System.out.println("----------------------------");
        System.out.println(" ");
        System.out.println("Average Frequency: " + freqA + " Precentage Sum: " + percentS);
        System.out.println(" ");
        System.out.println("Program Finished");
        System.out.println(" ");             
    }
}


/*  NOTE FOR TEACHER: Sorry that I left a bunch of code down here last time, my bad!
    I just had the code down here for testing purposes, and I usually delete it afterwards. 

    Also, I am unsure as to why the code didn't work when downloaded from GitHub, since I had tested it multiple times, and every time it worked as intended.

    And one more thing, I hadn't added the second part of the code because in the instructions it said that the second part would be due next week. Only after
    re-reading the instructions about three times did I notice that the sentence "but I want you to start on it this week" was reffering to the second part, and not
    the overall assignment. Sorry about that!


*/