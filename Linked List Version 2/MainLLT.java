// Main Linked List Test
// Made By: Henry Smith
// Created: 3/25/25

// Purpose: Used to test the LinkedListV2 program

import java.util.Scanner;

public class MainLLT {
    public static void main (String[] args) {

        String itemName;
        String itemData;
        int iCounter = 0;

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("Starting Program...");
        System.out.println(" ");
        Scanner userInput = new Scanner(System.in);
        ContainerClass containerA = new ContainerClass();


        // Asks the user for the number and name of 5 different objects, which will be placed into a LinkedList
        for (int x = 1; x <= 5 ; x++) {
            System.out.println(" ");
            iCounter += 1;
            int itemNum = iCounter;
            System.out.println("Please insert the item "+ iCounter +"'s name");
            itemName = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            System.out.println("Please insert the item "+ iCounter +"'s data that it will store");
            itemData = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            containerA.add(itemName, itemNum, itemData);
        }
        

        // EXTRA CODE: Tells the user that the program is creating a container(LinkedList)
        System.out.println(" ");
        System.out.println("Now printing the item in the newly created container...");
        System.out.println(" ");

        // Prints the container from the head item to the tail item
        System.out.println("- CONTAINER CONTENTS (Head to Tail) -");
        containerA.openContainerTB();
        System.out.println(" ");

        // Prints the container from the head item to the tail item
        System.out.println("- CONTAINER CONTENTS (Tail to Head) -");
        containerA.openContainerBT();
        System.out.println(" ");

        // EXTRA CODE: Tells the user the program is finished
        System.out.println(" ");
        System.out.println("Program Finished");
        System.out.println(" ");
        userInput.close();
    }
}

