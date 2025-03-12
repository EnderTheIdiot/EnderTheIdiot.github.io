
// Container Test Program
// By Henry Smith
// Made: Mar 11 2025

import java.util.Scanner;

public class containerTest {



    public static void main (String[] args) {

        String itemName;
        int iCounter = 0;

        // EXTRA CODE
        System.out.println(" ");
        System.out.println("Starting Program...");
        System.out.println(" ");

        Scanner userInput = new Scanner(System.in);
        ItemContainer containerA = new ItemContainer();


        // Asks the user for the number and name of 5 objects total
        for (int x = 1; x <= 5 ; x++) {
            System.out.println(" ");
            iCounter += 1;
            int itemNum = iCounter;
            System.out.println("Please insert the item "+ iCounter +"'s name");
            itemName = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            containerA.add(itemName, itemNum);
        }
        

        // EXTRA CODE
        System.out.println(" ");
        System.out.println("Now printing the item in the newly created container...");
        System.out.println(" ");

        // Prints the container
        System.out.println("- CONTAINER CONTENTS -");
        containerA.openContainer();

        // EXTRA CODE
        System.out.println(" ");
        System.out.println("Program Finished");
        System.out.println(" ");
        userInput.close();
    }
}