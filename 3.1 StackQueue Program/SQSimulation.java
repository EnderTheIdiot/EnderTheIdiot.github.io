// Stacks and Queues Simulation 
// Made By: Henry Smith
// Created: 3/29/25
// Edited: 4/7/25

// Purpose: Used to test the stack and queue functions of the SQContainerClass in a real life secenario

import java.util.Scanner;

public class SQSimulation{
    public static void main(String[] args) {

        String itemName;
        String itemData;
        int iCounter = 0;
        int oCounter = 0;
        String Empty1;
        int userCommand = 1;

        // EXTRA CODE: Tells the user the program is running
        System.out.println(" ");
        System.out.println("Programing Running...");
        System.out.println(" ");
        System.out.println("Initiating Disk Stack Program Test...");
        System.out.println(" ");
        System.out.println("- DISC STACK SIMULATION TEST -");
        Scanner userInput = new Scanner(System.in);
        SQContainerClass discStackA = new SQContainerClass();

        // Asks the user how many discs they would like to put into a disc stack
        System.out.println("How many discs would you like to insert into the Disc Stack?");
        try {
            oCounter = userInput.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect Input! [" + e +"]   Please try again!");
            userInput.next();
            oCounter = userInput.nextInt();
        }


        // Asks the user for the number and name for each disc you want placed in the disc stack (LinkedList)
        Empty1 = userInput.nextLine();
        for (int x = 1; x <= oCounter; x++) {
            System.out.println(" ");
            iCounter += 1;
            int itemNum = iCounter;
            System.out.println("Please insert Disc "+ iCounter +"'s name");
            itemName = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            System.out.println("Please insert Disc "+ iCounter +"'s data that it will store");
            itemData = userInput.nextLine();
            System.out.println("Input Accepted");
            System.out.println(" ");
            discStackA.addTop(itemName, itemNum, itemData);
        }

        System.out.print(" " + Empty1);

        // Asks the user what they want to do until they respond with the number 5
        for (int x = 1; userCommand <= 4; x++) {
            System.out.println(" ");
            System.out.println("- Command No."+x+" -");
            System.out.println("What do you want to do with the Disc Stack?");
            System.out.println("[1] Look at the info of the top disc");
            System.out.println("[2] Remove the top disc");
            System.out.println("[3] Look at the full stack info");
            System.out.println("[4] Add a new disc");
            System.out.println("[5] End Program");
            if (userInput.hasNextInt()) {
                userCommand = userInput.nextInt();
                if (userCommand <= 5){
                } else {                
                    System.out.println("Incorrect Input! Please enter a 1 or 2!");
                }
            }

            if (userCommand == 1){
                System.out.println("-------------------------");               
                System.out.println("[Top Disc Info]");
                System.out.println(" " + discStackA.lookTop());
                System.out.println("-------------------------");   
                System.out.println(" ");
                System.out.println(" ");
            }

            if (userCommand == 2){ 
                System.out.println("-------------------------");               
                System.out.println("[Removed Disc Info]");
                System.out.println(" " + discStackA.removeTop());
                System.out.println("-------------------------");   
                System.out.println(" ");
                System.out.println(" ");
            }

            if (userCommand == 3){    
                System.out.println("-------------------------");            
                System.out.println("[Disc Stack Info]");
                discStackA.openContainerTB();
                System.out.println("-------------------------");   
                System.out.println(" ");
                System.out.println(" ");
            }

            if (userCommand == 4){               
                System.out.println(" ");
                iCounter += 1;
                int itemNum = iCounter;
                System.out.println("Please insert Disc "+ iCounter +"'s name");
                Empty1 = userInput.nextLine();
                itemName = userInput.nextLine();
                System.out.println("Input Accepted");
                System.out.println(" ");
                System.out.println("Please insert Disc "+ iCounter +"'s data that it will store");
                itemData = userInput.nextLine();
                System.out.println("Input Accepted");
                System.out.println(" ");
                discStackA.addTop(itemName, itemNum, itemData);
                System.out.print(" " + Empty1);
            }

            if (userCommand == 5){               
                System.out.println("Ending Program...");
            }

            if (userCommand >= 6){               
                System.out.println("An error occured, please try again!");
            }   
        }

        // EXTRA CODE: Tells the user the program is finished
        System.out.println(" ");
        System.out.println("Program Finished");
        System.out.println(" ");

        userInput.close();
    }
}
