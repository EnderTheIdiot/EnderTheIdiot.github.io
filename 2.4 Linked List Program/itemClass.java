// Item Class
// By Henry Smith
// Made: Mar 10 2025

// This class is used for the LinkedList program to create a linked list without using the java.util.LinkedList
class Item {
    String name;
    int number;
    Item next;

    Item(String name, int number) {
        this.name = name;
        this.number = number;
        this.next = null;
    }
}
