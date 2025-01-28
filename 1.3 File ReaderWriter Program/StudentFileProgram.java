// Student File Reader/Writer Program
// Made by: Henry Smith
// Created: 1/24/2025
// Edited: 1/28/2025

import java.io.IOException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentFileProgram {
    public static void main(String[] args) {

        // Creates a variable that is attached to the user's inputs
        Scanner Userinput = new Scanner(System.in);

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("Program Running...");
        System.out.println(" ");

            // Asks for the student's first name
            System.out.println(" ");
            System.out.println("Insert First Name:");
            String studentFName = Userinput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");

            // Asks for the student's last name
            System.out.println("Insert Last Name:");
            String studentLName = Userinput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");

            // Asks for the student's grade/schoolyear
            System.out.println("Insert Grade:");
            String studentGrade = Userinput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");

            // Asks for the student's grade/schoolyear
            System.out.println("Insert Name of School:");
            String studentSchool = Userinput.nextLine();
            System.out.println("Input Accepted");                
            System.out.println(" ");
            Userinput.close();

            // Prints out the collected inputs
            System.out.println(" ");
            System.out.println("Your Inputs:");
            System.out.println("----------------------");
            System.out.println("First Name = " + studentFName);
            System.out.println("Last Name = " + studentLName);
            System.out.println("Grade = " + studentGrade);
            System.out.println("School = " + studentSchool);

                // EXTRA CODE: Tells the user it's creating the file
                System.out.println(" ");
                System.out.println( "Creating new file. . ."); 

                    // Creates a new file called "student.txt", and converts the collected inputs into bytes that are then transfered to the "student.txt" file
                    try (FileOutputStream StudentFile = new FileOutputStream("student.txt")) {
                        System.out.println(" ");
                        System.out.println( "Adding Inputs to new file. . ."); 
                        String Line1 = "Student Name: " + studentFName + " " + studentLName;
                        String Line2 = "  Student Grade: " + studentGrade;
                        String Line3 = "  Student School: " + studentSchool;
                        byte[] Data1 = Line1.getBytes();
                        byte[] Data2 = Line2.getBytes();
                        byte[] Data3 = Line3.getBytes();
                        StudentFile.write(Data1);
                        StudentFile.write(Data2);
                        StudentFile.write(Data3);
                    }   catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }

        // EXTRA CODE: Tells the user the program is printing out the contents of the newly edited file
        System.out.println(" ");
        System.out.println("Now printing file contents. . .");
        System.out.println(" ");
        System.out.println("The contents of [student.txt] are as follows...");
        System.out.println(" ");

                        // Reads the file using a buffered reader, and prints out each line of text as a String
                        try (BufferedReader studentFileR = new BufferedReader(new FileReader("student.txt")))  {
                            String text;
                            while ((text = studentFileR.readLine()) != null)
                            System.out.println(" " + text);
                        }   catch (IOException e) {
                            System.err.println("File Reading Error " + e.getMessage());
                        }


        // EXTRA CODE: Tells the user the program has finished running           
        System.out.println(" ");
        System.out.println( "Program Finished");

    }
}
