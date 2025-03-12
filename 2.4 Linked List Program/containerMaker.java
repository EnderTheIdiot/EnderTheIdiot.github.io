
// Creates a class that allows you to make a linked list
class ItemContainer {
    
    Item container;

        // Creates a new node for the list if the head node is empty
        public ItemContainer() {
            this.container = null;
        }

        public void add(String name, int number) {
            Item newContainer = new Item(name, number);
            if (container == null) {
                container = newContainer;
            } else { 
                Item currentI = container;
                    while (currentI.next != null) {
                        currentI = currentI.next;
                }   

                currentI.next = newContainer;
            }
        }

        // Allows you to print out the linked list
        public void openContainer() {
            Item currentI = container;
            while(currentI != null) {
                System.out.println("Item " + currentI.number + " = " + currentI.name);
                currentI = currentI.next;
            }
            System.out.println();
        }
    }
