import java.util.Comparator;
import java.util.LinkedList;

public class CustomPQ {
    private LinkedList<QueueNode> nodes = new LinkedList<>();

    public CustomPQ(TreeNode root) {
        preOrder(root);
        nodes.sort(new MyComparator());
    }

    public CustomPQ(Tree myTree) {
        QueueNode temp = new QueueNode(myTree.getRoot().task, myTree.getRoot().level);
        nodes.add(temp);

        for (TreeNode vertex: myTree.getVertices()) {
            temp = new QueueNode(vertex.task, vertex.level);
            nodes.add(temp);
        }

        nodes.sort(new MyComparator());
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        QueueNode temp = new QueueNode(root.task, root.level);
        nodes.add(temp);

        for (TreeNode child: root.children) {
            preOrder(child);
        }
    }

    public void addEntry(QueueNode task) {
        nodes.add(task);
        nodes.sort(new MyComparator());
        System.out.println("[SUCCESS] The task has successfully been added to the priority queue!");
    }

    public QueueNode getNewTask() {
        QueueNode nodeToBeReturned = null;
        if (nodes.size() == 0) {
            System.out.println("[FAILURE] Sorry, your task list is empty!");
        } else {
            nodeToBeReturned = nodes.getFirst();
        }

        return nodeToBeReturned;
    }

    public QueueNode removeEntry() {
        QueueNode nodeToBeReturned = null;
        if (nodes.size() == 0) {
            System.out.println("[FAILURE] Sorry, your task list is empty!");
        } else {
            System.out.println("[SUCCESS] A task has successfully been removed from the priority queue!");
            nodeToBeReturned = nodes.removeFirst();
        }

        return nodeToBeReturned;
    }

    public void print() {
        for (int i = 0; i < nodes.size(); i++) {
            if (i != nodes.size() - 1) {
                nodes.get(i).print();
                System.out.print(" --> ");
            } else {
                nodes.get(i).print();
                System.out.println();
            }
        }
    }
}

class QueueNode {
    protected String task;
    protected int level;

    public QueueNode(String task, int level) {
        this.task = task;
        this.level = level;
    }

    public void print() {
        System.out.print("(" + task + ", " + level + ")");
    }
}

class MyComparator implements Comparator<QueueNode> {
    @Override
    public int compare(QueueNode q1, QueueNode q2) {
        if (q1.level > q2.level) {
            return -1;
        } else if (q1.level < q2.level) {
            return 1;
        } else {
            return 0;
        }
    }
}
