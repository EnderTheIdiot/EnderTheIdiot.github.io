// Simple Object Class (For LinkedList V2)
// Made By: Henry Smith
// Created: 3/25/25

// Purpose: Used as a constructor for an Item object that works as a node for a LinkedList knwon as the ContainerClass

class Item {

    String iName;
    int iNumber;
    String iData;
    Item nextI;
    Item prevI;

    // The Item Object Constructor (a LinkedList Node)
    Item(String name, int number, String data) {
        this.iName = name;
        this.iNumber = number;
        this.iData = data;
        this.nextI = null;
        this.prevI = null;
    }
}