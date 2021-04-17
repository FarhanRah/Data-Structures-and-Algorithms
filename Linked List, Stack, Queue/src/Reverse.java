public class Reverse {

    public static void iterativeReverse(LinkedList list, Node head) {
        if (head == null || head.getNext() == null) {
            System.out.println("[REVERSE ERROR] The list can not be reversed because it has 1 or less node.");
        } else {
            Node prev = null;
            Node temp;

            while (head != null) {
                temp = head.getNext();
                head.setNext(prev);
                prev = head;
                head = temp;
            }

            list.setHead(prev);
        }
    }

    public static void recursiveReverse(LinkedList list, Node head) {
        if (head == null) {
            return;
        }

        if (head.getNext() == null) {
            list.setHead(head);
            return;
        }

        recursiveReverse(list, head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
    }
}

class LinkedList {

    private Node head;
    private int size;

    // Getters
    public int getSize() {
        return size;
    }
    public Node getHead() {
        return head;
    }

    // Setters
    public void setHead(Node n) {
        head = n;
    }

    // Additional functions
    public void add(Node node) {
        if (size == 0) {
            head = node;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }

        size++;
    }
    public void remove() {
        head = head.getNext();
        size--;
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            if (temp.getNext() == null) {
                System.out.print(temp.getData() + " --> NULL\n");
            } else {
                System.out.print(temp.getData() + " --> ");
            }
            temp = temp.getNext();
        }
    }
}

class Node {

    private String data;
    private Node next;

    public Node (String input)
    {
        data = input;
        next = null;
        }
    public void setNext(Node newNext)
    {
        next = newNext;
    }
    public Node getNext()
    {
        return next;
    }
    public void setData(String newData)
    {
        data = newData;
    }
    public String getData()
    {
        return data;
    }
}
