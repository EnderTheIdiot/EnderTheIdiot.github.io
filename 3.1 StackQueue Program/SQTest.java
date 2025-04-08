// Stacks and Queues Test Program (SQTest)
// Made By: Henry Smith
// Created: 3/29/25
// Edited: 4/7/25

// Purpose: Used to test the stack and queue functions of the SQContainerClass

import java.util.Scanner;

public class SQTest {
    public static void main(String[] args) {

        String itemName;
        String itemData;
        int iCounter = 0;
        int oCounter = 0;
        int storeType = 0;
        String Empty1;

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("Programing Running...");
        System.out.println(" ");
        System.out.println("Initiating Stacks & Queues Program Test...");
        System.out.println(" ");
        System.out.println("- STACKS & QUEUES TEST -");
        System.out.println(" ");
        Scanner userInput = new Scanner(System.in);
        SQContainerClass containerA = new SQContainerClass();

        // Asks the user how many objects they would like to put into a LinkedList
        System.out.println("How many objects would you like to insert into a LinkedList?");
        try {
            oCounter = userInput.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect Input! [" + e +"]   Please try again!");
            userInput.next();
            oCounter = userInput.nextInt();
        }

        // Asks the user how the Objects should be stored
        System.out.println(" ");
        System.out.println("How should the data be stored?");
        System.out.println("[1] Stack");
        System.out.println("[2] Queue");
        System.out.println("[3] List");
        try {
            storeType = userInput.nextInt();
            if (storeType >=4) {
                System.out.println("Incorrect Input! Please try again!");
                storeType = userInput.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect Input! [" + e +"]   Please try again!");
            userInput.next();
        }

        // Asks the user for the number and name for each object you want placed in the linked list.
        Empty1 = userInput.nextLine();
        for (int x = 1; x <= oCounter; x++) {
            System.out.println(" ");
            iCounter += 1;
            int itemNum = iCounter;
            System.out.println("Please insert Item "+ iCounter +"'s name");
            itemName = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            System.out.println("Please insert Item "+ iCounter +"'s data that it will store");
            itemData = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            if (storeType == 1){
                containerA.addTop(itemName, itemNum, itemData);
            }
            if (storeType == 2){
                containerA.addBottom(itemName, itemNum, itemData);
            }
            if (storeType == 3){
                containerA.add(itemName, itemNum, itemData);
            }
            if (storeType >= 4){
                System.out.println(" ");
                System.out.println("The storage type number entered previously was invalid, and all objects entered are void.");
                System.out.println("Please close the program and restart!");
            }
        }

        // Prints out the list's contents
        System.out.print(" " + Empty1);
        System.out.println(" ");
        System.out.println("- List Contents -");
        containerA.openContainerTB();


        // EXTRA CODE: Tells the user the program is finished
        System.out.println(" ");
        System.out.println("Program Finished");
        System.out.println(" ");

        userInput.close();
    }
}
