// Card Object Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: ___


public class CardClass {
    
    // Card Attributes:
    String Suit; // Determines the suit of the card (Hearts, Diamonds, Spades, or Clubs)
    String Number; // The number of the card (2 through 10)
    int Value; // The value of the card in a poker game (2 through 13)

    public CardClass(String suit, String number, int value) {
        Suit = suit;
        Number = number;
        Value = value; 
        }

    public int getValue() {
        return Value;
        }

    public void setValue(int value) {
        Value = value;
        }

        @Override
        public String toString() {
            return " - " + Number + " of " + Suit + " ";
        }
    }

