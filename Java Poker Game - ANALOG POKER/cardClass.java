// Card Object Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024
// Edited: May 12, 2025

public class cardClass {
    
    // Card Attributes:
    String Suit;     // Determines the suit of the card (Hearts, Diamonds, Spades, or Clubs)
    String Number;   // The number of the card (2 through 10)
    int Value;       // The value of the card in a poker game (2 through 13)
    int cardAmmount = 7;


    public cardClass(String suit, String number, int value) {
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
    
    public String getSuit() {
        return Suit;
        }


     
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(" IIIIIIIIIIIIIIIIII ");
            sb.append("\n");
            sb.append(" II              II ");
            sb.append("\n");
            sb.append(" II  "+Suit+" "+Number+"         II "); 
            sb.append("\n");
            sb.append(" II              II ");
            sb.append("\n");
            sb.append(" II  [][][]      II ");
            sb.append("\n");
            sb.append(" II  []  [][][]  II ");
            sb.append("\n");
            sb.append(" II  [][][]  []  II ");
            sb.append("\n");
            sb.append(" II  []  [][][]  II "); 
            sb.append("\n");
            sb.append(" II  []  []      II ");
            sb.append("\n");
            sb.append(" II      []      II ");
            sb.append("\n");
            sb.append(" II          "+Number+" "+Suit+" II ");
            sb.append("\n");
            sb.append(" II              II ");
            sb.append("\n");
            sb.append(" IIIIIIIIIIIIIIIIII ");
            sb.append("\n");
            sb.append(System.lineSeparator());  
            return sb.toString();
        }
}
