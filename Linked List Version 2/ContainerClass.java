// Simple Container Class (For LinkedList V2)
// Made By: Henry Smith
// Created: 3/25/25

// Purpose: Used to make a LinkedList(Container) without the LinkedList java import

class ContainerClass {
    
    private Item headItem;
    private Item tailItem;
    private int containerSize;

    // Sets the values of the variables for the first and last item in the container, along with the size of the container
    public ContainerClass() {
        this.headItem = null;
        this.tailItem = null;
        this.containerSize = 0;
    }

    // Creates a method for adding a new item(Node)to the made container(LinkedList)
    public void add(String name, int number, String data) {
        Item newItem = new Item(name, number, data);
        if (headItem == null) {
            headItem = newItem;
            tailItem = newItem;
        } else {
            tailItem.nextI = newItem;
            newItem.prevI = tailItem;
            tailItem = newItem;
        }
        containerSize++;
    }


    // Creates a method that allows you to print out the linked list from the head item to the tail item
    public void openContainerTB() {
        Item currentI = headItem;
        while(currentI != null) {
            System.out.println("Item " + currentI.iNumber + " = " + currentI.iName + " Data = " + currentI.iData);
            currentI = currentI.nextI;
        }
        System.out.println();
    }

    // Creates a method that allows you to print out the linked list from the tail item to the head item
    public void openContainerBT() {
        Item currentI = tailItem;
        while(currentI != null) {
            System.out.println("Item " + currentI.iNumber + " = " + currentI.iName + " Data = " + currentI.iData);
            currentI = currentI.prevI;
        }
        System.out.println();
    }

    // Creates a method for obtaining the size of the container(LinkedList)
    public int getContainerSize() {
        return containerSize;
    }
}

