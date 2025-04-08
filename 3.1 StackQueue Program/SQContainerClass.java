// Simple Container Class (For Stacks and Queues program)
// Made By: Henry Smith
// Created: 3/25/25
// Edited: 4/7/25

// Purpose: Used to make a LinkedList(Container) without the LinkedList java import

class SQContainerClass {
    
    private SQItem headItem;
    private SQItem tailItem;
    private int containerSize;

    // Sets the values of the variables for the first and last item in the container, along with the size of the container
    public SQContainerClass() {
        this.headItem = null;
        this.tailItem = null;
        this.containerSize = 0;
    }

    // Creates a method for adding a new item(Node)to the LinkedList
    public void add(String name, int number, String data) {
        SQItem newItem = new SQItem(name, number, data);
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

    // Creates a method for adding a new item(Node)to the top of the LinkedList (works as the push() feature for stacks)
    public void addTop(String name, int number, String data) {
        SQItem newItem = new SQItem(name, number, data);
        newItem.nextI = headItem;
        headItem = newItem;
        containerSize++;
    }

    // Creates a method for removing the first item in the LinkedList (works as the "dequeue()" feature for queues, and the "pop()" feature for stacks)
    public SQItem removeTop() {
        if (headItem == null){
            return null;
        }
        SQItem removedObject = headItem;
        headItem = headItem.nextI;
        containerSize--;
        return removedObject;
    }


    // Creates a method for adding a new item(Node)to the bottom of the LinkedList (works as the "enqueue()" feature for queues)
    public void addBottom(String name, int number, String data) {
        SQItem newItem = new SQItem(name, number, data);
        if (headItem == null)  {
            headItem = newItem;
        } else {
            SQItem currentHead = headItem;
            while (currentHead.nextI!= null) {
                currentHead = currentHead.nextI;
            }
            currentHead.nextI = newItem;
            
        }
        containerSize++;
    }


    // Creates a method for returning the object on the top of the list
    public SQItem lookTop() {
        //System.out.println("Item " + headItem.iNumber + " = " + headItem.iName + " | " + headItem.iName + "'s data = " + headItem.iData);
        return headItem == null ? null : headItem;
        }



    // Creates a method for returning the object at the bottom of the list
    public SQItem lookBottom() {
        if(headItem == null) return null;
        if(headItem.nextI == null) return headItem;
        SQItem currentItem = headItem;
        while(currentItem.nextI != null) {
            currentItem = currentItem.nextI;
        }
        //System.out.println("Item " + currentItem.iNumber + " = " + currentItem.iName + " | " + currentItem.iName + "'s data = " + currentItem.iData);
        return currentItem;
    }


    // Creates a method that allows you to print out the linked list from the head item to the tail item
    public void openContainerTB() {
        SQItem currentI = headItem;
        while(currentI != null) {
            System.out.println("Item " + currentI.iNumber + " = " + currentI.iName + " | " + currentI.iName + "'s data = " + currentI.iData);
            currentI = currentI.nextI;
        }
        System.out.println();
    }

    // Creates a method that allows you to print out the linked list from the tail item to the head item
    public void openContainerBT() {
        SQItem currentI = tailItem;
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

