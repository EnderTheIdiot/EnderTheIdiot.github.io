// String Manipulator Class
// Made by Henry Smith
// For Software and Programming Dev 2 Class
// Project Started: Feb 4 2025
// Project Finished: Feb 4 2025

import java.util.Scanner;

public class StringM {
    public static void main(String[] args) {

// The String Seperation Test

        // Creates the variables for seperating the TEST string
        String testDelimiter = " ";
        int testStartI = 0;
        int testEndI;
        int testWordCount = 0;

        String testString = "the quick brown fox jumped over the lazy dog";

        // EXTRA CODE: Tells the user it is currently seperating and print the words of the string
        System.out.println(" ");
        System.out.println("Running String Manipulator Class [StringM]...");
        System.out.println(" ");
        System.out.println("Seperating TEST string...");
        System.out.println(" ");
        System.out.println("Words of TEST string");
        System.out.println("-------------------");

            // Counts the letters of the TEST string, and prints/counts each word as it encounters a space
            while ((testEndI = testString.indexOf(testDelimiter, testStartI)) != -1) {
                String word = testString.substring(testStartI, testEndI);
                System.out.println(word); 
                testWordCount = testWordCount + 1;
                testStartI = testEndI + testDelimiter.length();
            }   
            
            // Prints the last word of the string 
            if (testStartI < testString.length())   {
                String word = testString.substring(testStartI);
                System.out.println(word); 
                testWordCount = testWordCount + 1;
            }
        
        // EXTRA CODE: Tells the user the total word count of the string
        System.out.println("-------------------");
        System.out.println("Total TEST String word count = " + testWordCount);
        System.out.println("-------------------");
        System.out.println(" ");
        System.out.println("Seperation Test Complete!");
        System.out.println(" ");


// After the String Seperation Test is complete, the program moves on and asks the user to input a string for seperating

        // Creates the variables for seperating the string inputed by the user
        String Delimiter = " ";
        int StartI = 0;
        int EndI;
        int WordCount = 0;

        // EXTRA CODE: Asks the user for a string input
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("[Please Input a String for Seperation Below!]");
        String StringInput= input.nextLine();
        System.out.println("[Input Accepted]");
        System.out.println(" ");
        System.out.println("Seperating TEST string...");
        System.out.println(" ");
        System.out.println("Words of TEST string");
        System.out.println("-------------------");

            // Counts the letters of the user's inputed string, and prints/counts each word as it encounters a space
            while ((EndI = StringInput.indexOf(Delimiter, StartI)) != -1) {
                String word = StringInput.substring(StartI, EndI);
                System.out.println(word); 
                WordCount = WordCount + 1;
                StartI = EndI + Delimiter.length();
            }   
            
            // Prints the last word of the string 
            if (StartI < StringInput.length())   {
                String word = StringInput.substring(StartI);
                System.out.println(word); 
                WordCount = WordCount + 1;
            }

        // EXTRA CODE: Tells the user the total word count of the string
        System.out.println("-------------------");
        System.out.println("Total User Input String word count = " + WordCount);
        System.out.println("-------------------");
        System.out.println("Program Finshed");
        input.close();
        System.out.println(" ");
        
    }
}
