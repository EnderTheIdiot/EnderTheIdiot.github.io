// Score Manager Class (for "Java Poker Game")
// By: Henry Smith
// Started: May 6, 2025
// Finished: May 12, 2025


public class scoreManager {

// 1. Intializes the variables for checking poker hands
    static String heartFlush = "[♥︎, ♥︎, ♥︎, ♥︎, ♥︎]";
    static String spadeFlush = "[♠︎, ♠︎, ♠︎, ♠︎, ♠︎]";
    static String clubFlush = "[♣︎, ♣︎, ♣︎, ♣︎, ♣︎]";
    static String diamondFlush = "[♦︎, ♦︎, ♦︎, ♦︎, ♦︎]";
    static  String Straight1 = "[2, 3, 4, 5, 6]";
    static String Straight2 = "[3, 4, 5, 6, 7]";
    static String Straight3 = "[4, 5, 6, 7, 8]";
    static  String Straight4 = "[5, 6, 7, 8, 9]";
    static String Straight5 = "[6, 7, 8, 9, 10]";
    static String Straight6 = "[7, 8, 9, 10, 11]";
    static  String Straight7 = "[8, 9, 10, 11, 12]";
    static  String Straight8 = "[9, 10, 11, 12, 13]";
    static  String Straight9 = "[10, 11, 12, 13, 14]";
    static boolean isFlush;
    static boolean isStraight;
    static int equalValues;

// 2. When active, this method checks to see if the played hand is a Flush
    public static boolean checkFlush(String allHandSuits) {
        if (true == allHandSuits.equals(heartFlush)) {
            isFlush = true;
        } 
        if (true == allHandSuits.equals(spadeFlush)) {
            isFlush = true;
        } 
        if (true == allHandSuits.equals(clubFlush)) {
            isFlush = true;
        } 
        if (true == allHandSuits.equals(diamondFlush)) {
            isFlush = true;
        } 
        if (true == isFlush) {
            return true;
        } else {
            return false;
        }
    }

// 3. When active, this method checks to see if the played hand is a Straight
    public static boolean checkStraight(String allHandValues) {
        if (true == allHandValues.equals(Straight1)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight2)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight3)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight4)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight5)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight6)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight7)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight8)) {
            isStraight = true;
        } 
        if (true == allHandValues.equals(Straight9)) {
            isStraight = true;
        } 
        if (true == isStraight) {
            return true;
        } else {
            return false;
        }
    }

// 4. When active, this method checks to see how many equal values there are
    public static int checkOther(String allHandValues) {

        for (int x = 1; x < allHandValues.length(); x += 3) {
            for (int y = x + 3; y < allHandValues.length(); y++) {
                if (allHandValues.charAt(x) == allHandValues.charAt(y)) {
                    equalValues++;
                }
            }
        }
        return equalValues++;
    }

// 5. When active, this method checks to see if the played hand includes a pair
    public static boolean checkPair(int equalValAmn) {
        if (equalValAmn == 1) {
            return true;
        } else {
            return false;
        }
    }

// 6. When active, this method checks to see if the played hand includes two pairs
    public static boolean checkTwoPair(int equalValAmn) {
        if (equalValAmn == 2) {
            return true;
        } else {
            return false;
        }
    }

// 7. When active, this method checks to see if the played hand is a Full House
    public static boolean checkFullHouse(int equalValAmn) {
        if (equalValAmn == 3) {
            return true;
        } else {
            return false;
        }
    }

}

