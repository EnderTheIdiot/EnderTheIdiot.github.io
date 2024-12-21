// Card Game Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GameClass {   

    public static String suit;
    public static String number;
    public static int value; 



// 1: The starting point of the code 
    public static void main(String[] args) {

        
// 2: Creates a deck, and fills it with the DeckClass
    DeckClass TheDeck = new DeckClass();
        List<CardClass> Deck = TheDeck.fillTheDeck();


// 3: Makes an extra copy of the deck for shuffling (probably isn't nessacery but rather safe than sorry ;) )
        List<CardClass> NewDeck = new ArrayList<>();
            NewDeck.addAll(Deck);
            Collections.shuffle(NewDeck);


// 4: Creates new lists for each player, and fills that list with 7 cards from the shuffled deck
            List<CardClass> Player1 = new ArrayList<>();{
                Player1.addAll(NewDeck.subList(0 ,7));
            }
            List<CardClass> Player2 = new ArrayList<>();{
                Player2.addAll(NewDeck.subList(8 ,15));
            }
            List<CardClass> Player3 = new ArrayList<>();{
                Player3.addAll(NewDeck.subList(16 ,23));
            }
            List<CardClass> Player4 = new ArrayList<>();{
                Player4.addAll(NewDeck.subList(24 ,31));
            }
            List<CardClass> Player5 = new ArrayList<>();{
                Player5.addAll(NewDeck.subList(32 ,39));
            }


// 5: Prints out the start of the card game (EXTRA)
    System.out.println("CARD GAME"); 
    System.out.println("-------------------------------"); 
        

// 6: Player 1's hand, along with its overall value
    System.out.println("Player 1's Hand");
        for (CardClass Card : Player1) {
            System.out.println(Card); 
        }   
        int Player1sum = 0;
        for (CardClass Card : Player1) {
            Player1sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player1sum);
            System.out.println("-------------------------------"); 


// 7: Player 2's hand, along with its overall value       
    System.out.println("Player 2's Hand");
        for (CardClass Card : Player2) {
            System.out.println(Card); 
        }   
        int Player2sum = 0;
        for (CardClass Card : Player2) {
            Player2sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player2sum);
            System.out.println("-------------------------------"); 


// 8: Player 3's hand, along with its overall value
    System.out.println("Player 3's Hand");
        for (CardClass Card : Player3) {
            System.out.println(Card); 
        }   
        int Player3sum = 0;
        for (CardClass Card : Player3) {
            Player3sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player3sum);
            System.out.println("-------------------------------"); 


// 9: Player 4's hand, along with its overall value
    System.out.println("Player 4's Hand");
        for (CardClass Card : Player4) {
            System.out.println(Card); 
        }   
        int Player4sum = 0;
        for (CardClass Card : Player4) {
            Player4sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player4sum);
            System.out.println("-------------------------------"); 


// 10: Player 5's hand, along with its overall value
    System.out.println("Player 5's Hand");
        for (CardClass Card : Player5) {
            System.out.println(Card); 
        }   
        int Player5sum = 0;
        for (CardClass Card : Player5) {
        Player5sum += Card.getValue();
        }       
            System.out.println("Total Hand Value " + Player5sum);
            System.out.println("-------------------------------"); 


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


    }
}
     

