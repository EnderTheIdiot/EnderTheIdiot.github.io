// Card Game Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DGameClass {   

    public static String suit;
    public static String number;
    public static int value; 

// DEBUG: Change "false" to "true" in the command line below to toggle debug mode
    public static boolean debug = true; 

// DEBUG INFO: The purpose of this debug mode is to check Object, ArrayList, and Sublist values are correctly indentified, since one of 
//             the main problems I encountered was both incorrect deck and hand values, along with invalid cards or arraylists. 

// DEBUG: Defines where the debug information will be sent to (DebugLog.txt)
    public static String filename = "DebugLog.txt";
    public static String filename2 = "DebugDeck.txt";


// 1: The starting point of the code 
    public static void main(String[] args) throws IOException {

// DEBUG: Tells the user that Debug Mode has been enabled
        if (debug = true) {
            System.out.println(" ");
            System.out.println("Debug Mode Activated");
            System.out.println(" ");
            System.out.println("INFO: Debug information will be printed into the text file known as " + filename + ", as the program");
            System.out.println("      is running. Other than the inclusion of printed debug info in the file " + filename + ", the program ");
            System.out.println("      will run as normal.");
            System.out.println(" ");
            System.out.println("Now running main program...");
            System.out.println(" ");
        }

// DEBUG: Prints information into the debug log, showing that the DebugLog is receiving data
        BufferedWriter debugLogger = new BufferedWriter(new FileWriter(filename, true));
        if (debug = true) debugLogger.write("Debug Log: ENABLED");
        if (debug = true) debugLogger.newLine();
        if (debug = true) debugLogger.newLine();
        if (debug = true) debugLogger.write("------- DEBUG LOG -------");

// 2: Creates a deck, and fills it with the DeckClass
    DDeckClass TheDeck = new DDeckClass();
        List<DCardClass> Deck = TheDeck.fillTheDeck();


// 3: Makes an extra copy of the deck for shuffling (probably isn't nessacery but rather safe than sorry ;) )
        List<DCardClass> NewDeck = new ArrayList<>();
            NewDeck.addAll(Deck);
            Collections.shuffle(NewDeck);


// DEBUG: Prints out the shuffled deck into the DebugDeck.txt file to insure that the cards are all in the deck, and to show that the deck has been correctly shuffled
            if (debug = true) {
                BufferedWriter debugDecklogger = new BufferedWriter(new FileWriter(filename2, true));
                debugDecklogger.newLine();
                debugDecklogger.write("-------[SHUFFLED DECK]---------");
                for (DCardClass card : NewDeck) {
                    debugDecklogger.newLine();
                    debugDecklogger.write("[" + card + "]");
                }
                debugDecklogger.newLine();
                debugDecklogger.write("-------------------------------");
                debugDecklogger.newLine();
                debugDecklogger.close();
            }
            if (debug = true) debugLogger.newLine();
            if (debug = true) debugLogger.write("[Added 'NewDeck' to 'DebugDeck.txt']");

// 4: Creates new lists for each player, and fills that list with 7 cards from the shuffled deck
            List<DCardClass> Player1 = new ArrayList<>();{
                Player1.addAll(NewDeck.subList(0 ,7));
            }
            List<DCardClass> Player2 = new ArrayList<>();{
                Player2.addAll(NewDeck.subList(8 ,15));
            }
            List<DCardClass> Player3 = new ArrayList<>();{
                Player3.addAll(NewDeck.subList(16 ,23));
            }
            List<DCardClass> Player4 = new ArrayList<>();{
                Player4.addAll(NewDeck.subList(24 ,31));
            }
            List<DCardClass> Player5 = new ArrayList<>();{
                Player5.addAll(NewDeck.subList(32 ,39));
            }

// DEBUG: Prints out info that the cards from the NewDeck have been added into five sublist, and the exact cards each sublist contains. This is to check if the player sums are correctly identified
            if (debug = true) debugLogger.newLine();
            if (debug = true) {
                debugLogger.write("[Objects added from 'NewDeck' into five 'Player' sublists]");
                debugLogger.newLine();
                debugLogger.write("[Player 1's Hand]");
                for (DCardClass Card : Player1) {
                    debugLogger.newLine();
                    debugLogger.write("[" + Card + "]");
                }   
                debugLogger.newLine();
                debugLogger.write("[Player 2's Hand]");
                for (DCardClass Card : Player2) {
                    debugLogger.newLine();
                    debugLogger.write("[" + Card + "]");
                }   
                debugLogger.newLine();
                debugLogger.write("[Player 3's Hand]");
                for (DCardClass Card : Player3) {
                    debugLogger.newLine();
                    debugLogger.write("[" + Card + "]");
                }   
                debugLogger.newLine();
                debugLogger.write("[Player 4's Hand]");
                for (DCardClass Card : Player4) {
                    debugLogger.newLine();
                    debugLogger.write("[" + Card + "]");
                }   
                debugLogger.newLine();
                debugLogger.write("[Player 5's Hand]");
                for (DCardClass Card : Player1) {
                    debugLogger.newLine();
                    debugLogger.write("[" + Card + "]");
                }   
            }
// 5: Prints out the start of the card game (EXTRA)
    System.out.println("CARD GAME"); 
    System.out.println("-------------------------------"); 
        
// DEBUG: Prints out info that the "Card Game" from the program has started, showing in the debug log when the programs main function has started
    if (debug = true) debugLogger.newLine();
    if (debug = true) debugLogger.write("[Started Card Game...]");

// 6: Player 1's hand, along with its overall value
    System.out.println("Player 1's Hand");
        for (DCardClass Card : Player1) {
            System.out.println(Card); 
        }   
        int Player1sum = 0;
        for (DCardClass Card : Player1) {
            Player1sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player1sum);
            System.out.println("-------------------------------"); 


// 7: Player 2's hand, along with its overall value       
    System.out.println("Player 2's Hand");
        for (DCardClass Card : Player2) {
            System.out.println(Card); 
        }   
        int Player2sum = 0;
        for (DCardClass Card : Player2) {
            Player2sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player2sum);
            System.out.println("-------------------------------"); 


// 8: Player 3's hand, along with its overall value
    System.out.println("Player 3's Hand");
        for (DCardClass Card : Player3) {
            System.out.println(Card); 
        }   
        int Player3sum = 0;
        for (DCardClass Card : Player3) {
            Player3sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player3sum);
            System.out.println("-------------------------------"); 


// 9: Player 4's hand, along with its overall value
    System.out.println("Player 4's Hand");
        for (DCardClass Card : Player4) {
            System.out.println(Card); 
        }   
        int Player4sum = 0;
        for (DCardClass Card : Player4) {
            Player4sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player4sum);
            System.out.println("-------------------------------"); 


// 10: Player 5's hand, along with its overall value
    System.out.println("Player 5's Hand");
        for (DCardClass Card : Player5) {
            System.out.println(Card); 
        }   
        int Player5sum = 0;
        for (DCardClass Card : Player5) {
        Player5sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player5sum);
            System.out.println("-------------------------------"); 


// DEBUG: Prints out info to show that the hand value of the five players have been obtained, which is important for defining the game's winner(s)
if (debug = true) { 
    debugLogger.newLine();
    debugLogger.write("[Attempted to obtain player 1 hand value]");
    if (Player1sum >= 1) {
        debugLogger.newLine();
        debugLogger.write("[Player 1 Hand Value: Successfully Obtained]");
        debugLogger.newLine();
        debugLogger.write("[Player 1 Hand Value = " + Player1sum +"]");
    } else {
        debugLogger.newLine();
        debugLogger.write("[Player 1 Hand Value: Unsuccessfully Obtained]");
    }
}         
if (debug = true) { 
    debugLogger.newLine();
    debugLogger.write("[Attempted to obtain player 2 hand value]");
    if (Player2sum >= 1) {
        debugLogger.newLine();
        debugLogger.write("[Player 2 Hand Value: Successfully Obtained]");
        debugLogger.newLine();
        debugLogger.write("[Player 2 Hand Value = " + Player2sum +"]");
    } else {
        debugLogger.newLine();
        debugLogger.write("[Player 2 Hand Value: Unsuccessfully Obtained]");
    }
}    
if (debug = true) { 
    debugLogger.newLine();
    debugLogger.write("[Attempted to obtain player 3 hand value]");
    if (Player3sum >= 1) {
        debugLogger.newLine();
        debugLogger.write("[Player 3 Hand Value: Successfully Obtained]");
        debugLogger.newLine();
        debugLogger.write("[Player 3 Hand Value = " + Player3sum +"]");
    } else {
        debugLogger.newLine();
        debugLogger.write("[Player 3 Hand Value: Unsuccessfully Obtained]");
    }
}    
if (debug = true) { 
    debugLogger.newLine();
    debugLogger.write("[Attempted to obtain player 4 hand value]");
    if (Player4sum >= 1) {
        debugLogger.newLine();
        debugLogger.write("[Player 4 Hand Value: Successfully Obtained]");
        debugLogger.newLine();
        debugLogger.write("[Player 4 Hand Value = " + Player4sum +"]");
    } else {
        debugLogger.newLine();
        debugLogger.write("[Player 4 Hand Value: Unsuccessfully Obtained]");
    }
}    
if (debug = true) { 
    debugLogger.newLine();
    debugLogger.write("[Attempted to obtain player 5 hand value]");
    if (Player5sum >= 1) {
        debugLogger.newLine();
        debugLogger.write("[Player 5 Hand Value: Successfully Obtained]");
        debugLogger.newLine();
        debugLogger.write("[Player 5 Hand Value = " + Player5sum +"]");
    } else {
        debugLogger.newLine();
        debugLogger.write("[Player 5 Hand Value: Unsuccessfully Obtained]");
    }
}    

// 11: Prints out the results
System.out.println("FINAL RESULTS");
System.out.println("PLAYER 1'S HAND VALUE " + Player1sum);
System.out.println("PLAYER 2'S HAND VALUE " + Player2sum);
System.out.println("PLAYER 3'S HAND VALUE " + Player3sum);
System.out.println("PLAYER 4'S HAND VALUE " + Player4sum);
System.out.println("PLAYER 5'S HAND VALUE " + Player5sum);

// 12: Determines the winning hand
System.out.println("MEANING THE WINNER IS. . ."); 

    int WinningValue;
    WinningValue = 0;

        if (Player1sum > WinningValue)  {
            WinningValue = Player1sum;
        }
        if (Player2sum > WinningValue)  {
            WinningValue = Player2sum;
        }
        if (Player3sum > WinningValue)  {
            WinningValue = Player3sum;
        }
        if (Player4sum > WinningValue)  {
            WinningValue = Player4sum;
        }
        if (Player5sum > WinningValue)  {
            WinningValue = Player5sum;
        }
            if (Player1sum == WinningValue)  {
                System.out.println("PLAYER 1 WITH " + Player1sum + " POINTS!");
            }
            if (Player2sum == WinningValue)  {
                System.out.println("PLAYER 2 WITH " + Player2sum + " POINTS!");
            }
            if (Player3sum == WinningValue)  {
                System.out.println("PLAYER 3 WITH " + Player3sum + " POINTS!");
            }
            if (Player4sum == WinningValue)  {
                System.out.println("PLAYER 4 WITH " + Player4sum + " POINTS!");
            }
            if (Player5sum == WinningValue)  {
                System.out.println("PLAYER 5 WITH " + Player5sum + " POINTS!");
            }


// 13: Ends the game [EXTRA]
System.out.println("-------------------------------"); 
System.out.println("[END GAME]"); 
debugLogger.close();


    }
}
     

