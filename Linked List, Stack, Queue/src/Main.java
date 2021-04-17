import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // LIBRARY SYSTEM (2.1)
        System.out.println("Would you like to see the test run for '2.1 She Blinded Me With Library Science'? (Please type 'yes' or 'no'): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            // Creating a library object
            Library lib = new Library();
            lib.print();

            // Checking out a book
            lib.checkingOut(10);
            lib.checkingOut(2);
            lib.checkingOut(1);
            lib.print();

            // Returning a book
            lib.returning(-1);
            lib.returning(3);
            lib.returning(2);
            lib.print();

            // Checking the status of the book
            lib.status(-100);
            lib.status(0);

            // Checking the name of the book
            lib.name(7);
            lib.name(3);

            // Removing a book from shelves
            lib.remove(1);
            lib.remove(-999);
            lib.remove(2);
            lib.print();

            // Adding a book at an empty slot
            Book temp = new Book("Winnie The Pooh", "A.A.Milne", true, 2);
            lib.add(3, temp);
            lib.add(2, temp);
            lib.print();

            // Adding a book to any available empty slot, without providing it a precise ID
            Book temp2 = new Book("Harry Potter", "J.K Rowling", true, 0);
            lib.remove(3);
            lib.add(temp2);

            // Swapping a book
            temp = new Book("The Secret Garden", "Frances Hodgson Burnett", true, 0);
            lib.swap(0, temp);
            lib.print();

            // Checking the number of books, lent books etc
            lib.numOfBooks();
            System.out.println("--------------------------------------------");
        }
        // ----------------------------------------------------------------------------------------------------

        // STACK-BASED QUEUE (2.2)
        System.out.println("Would you like to see the test run for '2.2 Double-Back To The Future'? (Please type 'yes' or 'no'): ");
        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            // Creating the scanner and queue object
            Queue queue = new Queue();

            System.out.println("-------------------------------");
            // Asking the user for the entries of 4 days and adding them to our queue
            for (int i = 0; i < 4; i++) {
                System.out.println("Please enter the entry for day " + (i + 1) + ": ");
                String first = scanner.nextLine();
                queue.enqueue(first);
            }

            System.out.println("-------------------------------");
            // Checking the size of queue
            System.out.println("The current size of our queue is: " + queue.size() + ".");

            System.out.println("-------------------------------");
            // Checking the dequeue function
            String returnedValue = queue.dequeue();
            System.out.println("The value returned from dequeue is: " + returnedValue + ".");
            System.out.println("The size after trying dequeue is: " + queue.size() + ".");
            System.out.println("-------------------------------");
            returnedValue = queue.dequeue();
            System.out.println("The value returned from dequeue is: " + returnedValue + ".");
            System.out.println("The size after trying dequeue is: " + queue.size() + ".");

            System.out.println("-------------------------------");
            // Checking the front function
            System.out.println("The front value is: " + queue.front() + ".");

            System.out.println("-------------------------------");
            // Checking the isEmpty function
            System.out.println("Queue is empty: " + queue.isEmpty() + ".");
            System.out.println("-------------------------------");
            returnedValue = queue.dequeue();
            System.out.println("The value returned from dequeue is: " + returnedValue + ".");
            System.out.println("The size after trying dequeue is: " + queue.size() + ".");
            System.out.println("The current size of our queue is: " + queue.size() + ".");
            System.out.println("-------------------------------");
            returnedValue = queue.dequeue();
            System.out.println("The value returned from dequeue is: " + returnedValue + ".");
            System.out.println("The size after trying dequeue is: " + queue.size() + ".");
            System.out.println("The current size of our queue is: " + queue.size() + ".");
            System.out.println("-------------------------------");
            System.out.println("Queue is empty: " + queue.isEmpty() + ".");
            System.out.println("--------------------------------------------");
        }

        // REVERSING SINGLY-LINKED LIST (2.3)
        System.out.println("Would you like to see the test run for '2.3 Reversing Course'? (Please type 'yes' or 'no'): ");
        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            // Creating two lists two reverse
            LinkedList list1 = new LinkedList();
            LinkedList list2 = new LinkedList();

            // Asking the input from user
            System.out.println("--------------------------");
            System.out.println("Please input some data for the singly linked list:");
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + ") ");
                String data = scanner.nextLine();
                Node temp1 = new Node(data);
                Node temp2 = new Node(data);
                list1.add(temp1);
                list2.add(temp2);
            }
            System.out.println("--------------------------");

            // Reversing the LinkedList using iterative method
            System.out.println("--------------------------");
            System.out.println("List 1 before reversing it using iterative method is:");
            list1.print();
            Reverse.iterativeReverse(list1, list1.getHead());
            System.out.println("After reversing List 1 using iterative method:");
            list1.print();
            System.out.println("--------------------------");

            // Reversing the LinkedList using recursive method
            System.out.println("--------------------------");
            System.out.println("List 2 before reversing it using recursive method is:");
            list2.print();
            Reverse.recursiveReverse(list2, list2.getHead());
            System.out.println("After reversing List 2 using recursive method:");
            list2.print();
            System.out.println("--------------------------");
        }

        // RESTAURANT SYSTEM (2.4)
        System.out.println("Would you like to see the test run for '2.4 Order Up!'? (Please type 'yes' or 'no'): ");
        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            // Creating the restaurant object and printing
            Restaurant restaurant = new Restaurant();
            restaurant.print();

            // Adding to the back of the orders list
            for (int i = 0; i < 3; i++) {
                System.out.println("---------------------------");
                System.out.println("[NORMAL ORDER] Please input the item ID you would like: ");
                int item = scanner.nextInt();
                scanner.nextLine();
                RestaurantNode temp = new RestaurantNode(item);
                restaurant.add(temp);
                System.out.println("Current orders: ");
                restaurant.print();
            }

            // Adding a fast order (in front)
            System.out.println("---------------------------");
            System.out.println("[FAST ORDER] Please input the item ID for your fast order: ");
            int item = scanner.nextInt();
            scanner.nextLine();
            RestaurantNode temp = new RestaurantNode(item);
            restaurant.addFirst(temp);
            System.out.println("Current orders: ");
            restaurant.print();
            System.out.println("---------------------------");

            // Removing the orders once fulfilled using dequeue
            restaurant.dequeue();
            restaurant.dequeue();
            System.out.println("Orders left: ");
            restaurant.print();
            System.out.println("---------------------------");
        }
    }
}
