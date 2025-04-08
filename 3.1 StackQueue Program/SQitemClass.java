// Simple Object Class (For Stacks and Queues program)
// Made By: Henry Smith
// Created: 3/25/25
// Edited: 4/7/25

// Purpose: Used as a constructor for an Item object that works as a node for a LinkedList knwon as the ContainerClass

class SQItem {
    
    String iName;
    int iNumber;
    String iData;
    SQItem nextI;
    SQItem prevI;

    // The Item Object Constructor (a LinkedList Node)
    SQItem(String name, int number, String data) {
        this.iName = name;
        this.iNumber = number;
        this.iData = data;
        this.nextI = null;
        this.prevI = null;
    }

    // Creates a toString that overrides how SQItem objects are printed
    @Override
    public String toString() {
        return "Item " + iNumber + " = " + iName + " | " + iName + "'s data = " + iData;
    }
}
