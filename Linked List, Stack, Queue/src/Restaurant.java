public class Restaurant extends CustomDeque {

    public int dequeue() {
        if (head == null) {
            System.out.println("[RESTAURANT ERROR] The order list is empty!");
            return -1;
        } else {
            System.out.println("The first item on the list: " + head.getData() + " has been fulfilled.");
            int item = head.getData();
            head = head.getNext();
            size--;

            return item;
        }
    }

    public void print() {
        RestaurantNode temp = head;

        if (temp == null) {
            System.out.println("--- EMPTY LIST --- ");
        } else {
            while (temp != null) {
                if (temp.getNext() == null) {
                    System.out.print(temp.getData() + "\n");
                } else {
                    System.out.print(temp.getData() + " --> ");
                }
                temp = temp.getNext();
            }
        }
    }
}

class CustomDeque {
    protected RestaurantNode head;
    protected int size;

    // My custom deque will only have two functions, add (to the ending) and addFirst (add to the beginning)
    // The default add and addFirst return true once the item has been successfully added
    public boolean add(RestaurantNode node) {
        if (size == 0) {
            head = node;
        } else {
            RestaurantNode temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(node);
        }

        System.out.println("Item with ID: " + node.getData() + " has been successfully added to the end of the list.");
        size++;
        return true;
    }

    public boolean addFirst(RestaurantNode node) {
        node.setNext(head);
        head = node;
        size++;
        System.out.println("Item with ID: " + node.getData() + " has been successfully added to the front of the list.");
        return true;
    }
}

class RestaurantNode {

    private int data;
    private RestaurantNode next;

    public RestaurantNode (int input)
    {
        data = input;
        next = null;
    }
    public void setNext(RestaurantNode newNext)
    {
        next = newNext;
    }
    public RestaurantNode getNext()
    {
        return next;
    }
    public void setData(int newData)
    {
        data = newData;
    }
    public int getData()
    {
        return data;
    }
}
