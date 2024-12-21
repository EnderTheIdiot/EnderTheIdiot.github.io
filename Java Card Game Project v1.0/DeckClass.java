// Deck Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024

import java.util.ArrayList;
import java.util.List;

public class DeckClass  { // Holds every card in a 52 US Deck in Java objects

    public List<CardClass> fillTheDeck() {
    //public static void main(String[] args) {

    List<CardClass> Deck = new ArrayList<>(); 

    // All Heart Cards
    Deck.add(new CardClass("Hearts", "Two", 2));
    Deck.add(new CardClass("Hearts", "Three", 3));
    Deck.add(new CardClass("Hearts", "Four", 4));
    Deck.add(new CardClass("Hearts", "Five", 5));
    Deck.add(new CardClass("Hearts", "Six", 6));
    Deck.add(new CardClass("Hearts", "Seven", 7));
    Deck.add(new CardClass("Hearts", "Eight",8));
    Deck.add(new CardClass("Hearts", "Nine", 9));
    Deck.add(new CardClass("Hearts", "Ten", 10));
    Deck.add(new CardClass("Hearts", "Jack", 11));
    Deck.add(new CardClass("Hearts", "Queen", 12));
    Deck.add(new CardClass("Hearts", "King", 13));
    Deck.add(new CardClass("Hearts", "Ace", 14));

        // All Club Cards
        Deck.add(new CardClass("Clubs", "Two", 2));
        Deck.add(new CardClass("Clubs", "Three", 3));
        Deck.add(new CardClass("Clubs", "Four", 4));
        Deck.add(new CardClass("Clubs", "Six", 6));
        Deck.add(new CardClass("Clubs", "Seven", 7));
        Deck.add(new CardClass("Clubs", "Eight",8));
        Deck.add(new CardClass("Clubs", "Nine", 9));
        Deck.add(new CardClass("Clubs", "Ten", 10));
        Deck.add(new CardClass("Clubs", "Jack", 11));
        Deck.add(new CardClass("Clubs", "Queen", 12));
        Deck.add(new CardClass("Clubs", "King", 13));
        Deck.add(new CardClass("Clubs", "Ace", 14));


            // All Diamond Cards
            Deck.add(new CardClass("Diamonds", "Two", 2));
            Deck.add(new CardClass("Diamonds", "Three", 3));
            Deck.add(new CardClass("Diamonds", "Four", 4));
            Deck.add(new CardClass("Diamonds", "Five", 5));
            Deck.add(new CardClass("Diamonds", "Six", 6));
            Deck.add(new CardClass("Diamonds", "Seven", 7));
            Deck.add(new CardClass("Diamonds", "Eight",8));
            Deck.add(new CardClass("Diamonds", "Nine", 9));
            Deck.add(new CardClass("Diamonds", "Ten", 10));
            Deck.add(new CardClass("Diamonds", "Jack", 11));
            Deck.add(new CardClass("Diamonds", "Queen", 12));
            Deck.add(new CardClass("Diamonds", "King", 13));
            Deck.add(new CardClass("Diamonds", "Ace", 14));

                // All Spade Cards
                Deck.add(new CardClass("Spades", "Two", 2));
                Deck.add(new CardClass("Spades", "Three", 3));
                Deck.add(new CardClass("Spades", "Four", 4));
                Deck.add(new CardClass("Spades", "Five", 5));
                Deck.add(new CardClass("Spades", "Six", 6));
                Deck.add(new CardClass("Spades", "Seven", 7));
                Deck.add(new CardClass("Spades", "Eight",8));
                Deck.add(new CardClass("Spades", "Nine", 9));
                Deck.add(new CardClass("Spades", "Ten", 10));
                Deck.add(new CardClass("Spades", "Jack", 11));
                Deck.add(new CardClass("Spades", "Queen", 12));
                Deck.add(new CardClass("Spades", "King", 13));
                Deck.add(new CardClass("Spades", "Ace", 14));

                return Deck;
    }
}




    

    



       
   


