import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 2.1 Branching Out
        System.out.println("***********************");
        System.out.println("Creating a root node and printing it:");
        System.out.println("***********************");
        TreeNode root = new TreeNode(null, "Wake up in the morning", 11);
        root.print();

        System.out.println("***********************");
        System.out.println("Passing the root node as the parameter for my newly created tree: ");
        System.out.println("***********************");
        Tree myTree = new Tree(root);
        myTree.print();

        System.out.println("***********************");
        System.out.println("Creating 5 new nodes and then adding them to my tree:");
        System.out.println("***********************");
        TreeNode temp1 = new TreeNode(root, "Collect litter", 5);
        TreeNode temp2 = new TreeNode(root, "Direct Visitors", 8);
        TreeNode temp3 = new TreeNode(temp1, "Plant saplings", 3);
        TreeNode temp4 = new TreeNode(temp1, "Report smoke sightings", 10);
        TreeNode temp5 = new TreeNode(temp2, "Record wildlife sightings", 7);
        myTree.addNode(temp1);
        myTree.addNode(temp2);
        myTree.addNode(temp3);
        myTree.addNode(temp4);
        myTree.addNode(temp5);
        myTree.print();

        System.out.println("***********************");
        System.out.println("Asking the TA to enter details for one node:");
        System.out.println("***********************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the task string (for example 'Meeting the boss'): ");
        String taskFromTA = scanner.nextLine();
        System.out.println("The importance level will be: 3");
        TreeNode temp6 = new TreeNode(temp2, taskFromTA, 3);
        myTree.addNode(temp6);
        myTree.print();

        while (true) {
            System.out.print("[CONTINUE] Please enter 'yes' to continue: ");
            String choiceTA = scanner.nextLine().toLowerCase();

            if (choiceTA.equals("yes")) {
                break;
            }
        }


        System.out.println("***********************");
        System.out.println("Trying to remove some of the nodes from the tree and then printing my tree again:");
        System.out.println("***********************");
        myTree.removeNode(temp2);
        myTree.removeNode(temp6);
        myTree.print();

        System.out.println("***********************");
        System.out.println("Getting the root of my tree and printing it:");
        System.out.println("***********************");
        TreeNode rootOfTree = myTree.getRoot();
        rootOfTree.print();

        System.out.println("***********************");
        System.out.println("Getting the size of my tree:");
        System.out.println("***********************");
        int treeSize = myTree.size();

        System.out.println("***********************");
        System.out.println("Checking if my tree is empty:");
        System.out.println("***********************");
        boolean isTreeEmpty = myTree.isEmpty();
        System.out.println("[INFO] Tree is empty? " + isTreeEmpty + ".");

        System.out.println("***********************");
        System.out.println("Checking if tree node called 'temp1' is external or not:");
        boolean isTemp1NodeExternal = myTree.isExternal(temp1);
        System.out.println("Checking if tree node called 'temp6' is external or not:");
        boolean isTemp6NodeExternal = myTree.isExternal(temp6);

        System.out.println("***********************");
        System.out.println("Checking if tree node called 'temp2' is internal or not:");
        boolean isTemp2NodeInternal = myTree.isInternal(temp2);
        System.out.println("Checking if tree node called 'temp5' is internal or not:");
        boolean isTemp5NodeInternal = myTree.isInternal(temp5);

        System.out.println("***********************");
        System.out.println("Checking if tree node called 'temp3' is the root node or not:");
        boolean isTemp3RootNode = myTree.isRoot(temp3);
        System.out.println("[INFO] Is it a root node? " + isTemp3RootNode + ".");
        System.out.println("Checking if the actual root node is the root node or not:");
        boolean isRootRootNode = myTree.isRoot(root);
        System.out.println("[INFO] Is it a root node? " + isRootRootNode + ".");

        System.out.println("***********************");
        System.out.println("Calling the function that prints how many tasks there are at each importance level:");
        System.out.println("***********************");
        myTree.eachLevelTask();
        System.out.println("Note: Since we needed constant time complexity, I made an array and stored the number of " +
                "tasks at each importance level and then printed it manually rather than using any sort of loop.");


        // 2.2 Top Priority
        System.out.println("");
        System.out.println("");
        System.out.println("***********************");
        System.out.println("Creating a priority queue for 2.2 by passing the tree created for 2.1 as a parameter:");
        System.out.println("***********************");
        CustomPQ myPriority = new CustomPQ(myTree);
        myPriority.print();

        System.out.println("***********************");
        System.out.println("Now the manager is adding some more entries:");
        System.out.println("***********************");
        QueueNode firstNode = new QueueNode("Go for lunch break", 7);
        myPriority.addEntry(firstNode);
        myPriority.print();

        System.out.println("***********************");
        System.out.println("Worker retrieving the most prioritized task:");
        System.out.println("***********************");
        QueueNode returnedTask = myPriority.getNewTask();
        returnedTask.print();
        System.out.println("");
        myPriority.print();

        System.out.println("***********************");
        System.out.println("Worker removing tasks until the priority queue is empty:");
        System.out.println("***********************");
        for (int i = 0; i < 7; i++) {
            returnedTask = myPriority.removeEntry();
            returnedTask.print();
            System.out.println("");
        }
        myPriority.print();


        // 2.3 Heaps of Trouble
        System.out.println("");
        System.out.println("");
        System.out.println("Note: So if the heap prints: ('Text1', 11) -- > ('Text2', 6) --> ('Text3', 8) --> " +
                "('Text4', 3), this means that the root is 'Text1', the left child of root is 'Text2', the right " +
                "child of root is 'Text3', then the left child of roots left child is 'Text4' and so on.");
        System.out.println("I am printing the heap in this format so that it prints everything in one line itself, " +
                "rather than taking bunch of lines like the tree printing method.");
        System.out.println("I am extremely sorry if its confusing, if any further explanation needed, I am happy to provide a " +
                "clearly defined text file in .pdf format that could explain the output of printing the tree/heap.");
        System.out.println("Creating a priority queue based on heap for 2.3 by passing the tree as parameter:");
        Heap myHeap = new Heap(myTree);
        myHeap.print();

        System.out.println("***********************");
        System.out.println("Now the worker is adding a entry:");
        System.out.println("***********************");
        TreeNode workerEntry = new TreeNode(temp3, "Call my parents", 9);
        myHeap.addEntry(workerEntry);
        myHeap.print();

        System.out.println("***********************");
        System.out.println("Worker retrieving the most prioritized task:");
        System.out.println("***********************");
        returnedTask = myHeap.getEntry();
        returnedTask.print();
        System.out.println("");
        myHeap.print();

        System.out.println("***********************");
        System.out.println("Worker removing tasks until the heap is empty:");
        System.out.println("***********************");
        for (int i = 0; i < 7; i++) {
            returnedTask = myHeap.removeEntry();
            returnedTask.print();
            System.out.println("");
        }
        myHeap.print();

        System.out.println("");
        System.out.println("");
        System.out.println("Please add as many entries as you would like. If at any point you want to remove " +
                "the highest priority entry, simply type: 'remove', or if you are done adding all your entries " +
                "you can simply type 'exit'. ");
        while (true) {
            System.out.println("[ACTION] What would you like to do? ('add', 'remove', 'exit'/''): ");
            String actionChoice = scanner.nextLine().toLowerCase();

            if (actionChoice.equals("add")) {
                System.out.println("[ADD] Please input the task for the entry: ");
                String taskUser = scanner.nextLine();
                System.out.println("[ADD] Please input the importance level for the entry (between 1 and 10, inclusive): ");
                int levelUser = scanner.nextInt();
                scanner.nextLine();

                QueueNode userMade = new QueueNode(taskUser, levelUser);
                TreeNode userMade2 = new TreeNode(null, taskUser, levelUser);
                myPriority.addEntry(userMade);
                myHeap.addEntry(userMade2);

                System.out.println("[SUCCESS] Your entry has been added to both the priority queues.");
                System.out.println("Printing priority queue...");
                myPriority.print();
                System.out.println("Printing heap...");
                myHeap.print();
            } else if (actionChoice.equals("remove")) {
                System.out.println("[REMOVE] Executing the remove methods for both the priority queues...");
                QueueNode priorityRemove = myPriority.removeEntry();
                QueueNode HeapRemove = myHeap.removeEntry();
                if (priorityRemove != null && HeapRemove != null) {
                    System.out.print("Priority Queue: ");
                    priorityRemove.print();
                    System.out.println("");
                    System.out.print("Heap: ");
                    HeapRemove.print();
                    System.out.println("");
                }
            } else if (actionChoice.equals("exit") || actionChoice.equals("")) {
                System.out.println("[EXIT] You have successfully exited.");
                break;
            } else {
                System.out.println("[ERROR] You can only type 'add', 'remove', or ''/'exit'");
            }
        }
    }
}
