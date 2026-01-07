// Deck Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024
// Edited: May 12, 2025

import java.util.ArrayList;
import java.util.List;

public class deckClass  { 

// Holds every card in a 52 US Deck in Java objects
    public List<cardClass> fillTheDeck() {
    List<cardClass> Deck = new ArrayList<>(); 

// All Heart Cards
    Deck.add(new cardClass("♥︎", "2", 2));
    Deck.add(new cardClass("♥︎", "3", 3));
    Deck.add(new cardClass("♥︎", "4", 4));
    Deck.add(new cardClass("♥︎", "5", 5));
    Deck.add(new cardClass("♥︎", "6", 6));
    Deck.add(new cardClass("♥︎", "7", 7));
    Deck.add(new cardClass("♥︎", "8",8));
    Deck.add(new cardClass("♥︎", "9", 9));
    Deck.add(new cardClass("♥︎", "X", 10));
    Deck.add(new cardClass("♥︎", "J", 11));
    Deck.add(new cardClass("♥︎", "Q", 12));
    Deck.add(new cardClass("♥︎", "K", 13));
    Deck.add(new cardClass("♥︎", "A", 14));

// All Club Cards
    Deck.add(new cardClass("♣︎", "2", 2));
    Deck.add(new cardClass("♣︎", "3", 3));
    Deck.add(new cardClass("♣︎", "4", 4));
    Deck.add(new cardClass("♣︎", "5", 5));
    Deck.add(new cardClass("♣︎", "6", 6));
    Deck.add(new cardClass("♣︎", "7", 7));
    Deck.add(new cardClass("♣︎", "8",8));
    Deck.add(new cardClass("♣︎", "9", 9));
    Deck.add(new cardClass("♣︎", "X", 10));
    Deck.add(new cardClass("♣︎", "J", 11));
    Deck.add(new cardClass("♣︎", "Q", 12));
    Deck.add(new cardClass("♣︎", "K", 13));
    Deck.add(new cardClass("♣︎", "A", 14));


 // All Diamond Cards
    Deck.add(new cardClass("♦︎", "2", 2));
    Deck.add(new cardClass("♦︎", "3", 3));
    Deck.add(new cardClass("♦︎", "4", 4));
    Deck.add(new cardClass("♦︎", "5", 5));
    Deck.add(new cardClass("♦︎", "6", 6));
    Deck.add(new cardClass("♦︎", "7", 7));
    Deck.add(new cardClass("♦︎", "8",8));
    Deck.add(new cardClass("♦︎", "9", 9));
    Deck.add(new cardClass("♦︎", "X", 10));
    Deck.add(new cardClass("♦︎", "J", 11));
    Deck.add(new cardClass("♦︎", "Q", 12));
    Deck.add(new cardClass("♦︎", "K", 13));
    Deck.add(new cardClass("♦︎", "A", 14));

// All Spade Cards
    Deck.add(new cardClass("♠︎", "2", 2));
    Deck.add(new cardClass("♠︎", "3", 3));
    Deck.add(new cardClass("♠︎", "4", 4));
    Deck.add(new cardClass("♠︎", "5", 5));
    Deck.add(new cardClass("♠︎", "6", 6));
    Deck.add(new cardClass("♠︎", "7", 7));
    Deck.add(new cardClass("♠︎", "8",8));
    Deck.add(new cardClass("♠︎", "9", 9));
    Deck.add(new cardClass("♠︎", "X", 10));
    Deck.add(new cardClass("♠︎", "J", 11));
    Deck.add(new cardClass("♠︎", "Q", 12));
    Deck.add(new cardClass("♠︎", "K", 13));
    Deck.add(new cardClass("♠︎", "A", 14));

    return Deck;

    }
}

