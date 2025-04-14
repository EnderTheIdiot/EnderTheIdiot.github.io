// Deck Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024

import java.util.ArrayList;
import java.util.List;

public class DDeckClass  { // Holds every card in a 52 US Deck in Java objects

    public List<DCardClass> fillTheDeck() {
    //public static void main(String[] args) {

    List<DCardClass> Deck = new ArrayList<>(); 

    // All Heart Cards
    Deck.add(new DCardClass("Hearts", "Two", 2));
    Deck.add(new DCardClass("Hearts", "Three", 3));
    Deck.add(new DCardClass("Hearts", "Four", 4));
    Deck.add(new DCardClass("Hearts", "Five", 5));
    Deck.add(new DCardClass("Hearts", "Six", 6));
    Deck.add(new DCardClass("Hearts", "Seven", 7));
    Deck.add(new DCardClass("Hearts", "Eight",8));
    Deck.add(new DCardClass("Hearts", "Nine", 9));
    Deck.add(new DCardClass("Hearts", "Ten", 10));
    Deck.add(new DCardClass("Hearts", "Jack", 11));
    Deck.add(new DCardClass("Hearts", "Queen", 12));
    Deck.add(new DCardClass("Hearts", "King", 13));
    Deck.add(new DCardClass("Hearts", "Ace", 14));

        // All Club Cards
        Deck.add(new DCardClass("Clubs", "Two", 2));
        Deck.add(new DCardClass("Clubs", "Three", 3));
        Deck.add(new DCardClass("Clubs", "Four", 4));
        Deck.add(new DCardClass("Clubs", "Six", 6));
        Deck.add(new DCardClass("Clubs", "Seven", 7));
        Deck.add(new DCardClass("Clubs", "Eight",8));
        Deck.add(new DCardClass("Clubs", "Nine", 9));
        Deck.add(new DCardClass("Clubs", "Ten", 10));
        Deck.add(new DCardClass("Clubs", "Jack", 11));
        Deck.add(new DCardClass("Clubs", "Queen", 12));
        Deck.add(new DCardClass("Clubs", "King", 13));
        Deck.add(new DCardClass("Clubs", "Ace", 14));


            // All Diamond Cards
            Deck.add(new DCardClass("Diamonds", "Two", 2));
            Deck.add(new DCardClass("Diamonds", "Three", 3));
            Deck.add(new DCardClass("Diamonds", "Four", 4));
            Deck.add(new DCardClass("Diamonds", "Five", 5));
            Deck.add(new DCardClass("Diamonds", "Six", 6));
            Deck.add(new DCardClass("Diamonds", "Seven", 7));
            Deck.add(new DCardClass("Diamonds", "Eight",8));
            Deck.add(new DCardClass("Diamonds", "Nine", 9));
            Deck.add(new DCardClass("Diamonds", "Ten", 10));
            Deck.add(new DCardClass("Diamonds", "Jack", 11));
            Deck.add(new DCardClass("Diamonds", "Queen", 12));
            Deck.add(new DCardClass("Diamonds", "King", 13));
            Deck.add(new DCardClass("Diamonds", "Ace", 14));

                // All Spade Cards
                Deck.add(new DCardClass("Spades", "Two", 2));
                Deck.add(new DCardClass("Spades", "Three", 3));
                Deck.add(new DCardClass("Spades", "Four", 4));
                Deck.add(new DCardClass("Spades", "Five", 5));
                Deck.add(new DCardClass("Spades", "Six", 6));
                Deck.add(new DCardClass("Spades", "Seven", 7));
                Deck.add(new DCardClass("Spades", "Eight",8));
                Deck.add(new DCardClass("Spades", "Nine", 9));
                Deck.add(new DCardClass("Spades", "Ten", 10));
                Deck.add(new DCardClass("Spades", "Jack", 11));
                Deck.add(new DCardClass("Spades", "Queen", 12));
                Deck.add(new DCardClass("Spades", "King", 13));
                Deck.add(new DCardClass("Spades", "Ace", 14));

                return Deck;
    }
}




    

    



       
   


