import java.util.LinkedList;

public class Tree {
    private TreeNode root;
    private LinkedList<TreeNode> vertices;
    private int size;
    private int[] taskLevelCounter;

    public Tree(TreeNode root) {
        this.root = root;
        vertices = new LinkedList<>();
        size = 1;
        taskLevelCounter = new int[10];
    }

    public TreeNode getRoot() {
        return root;
    }

    public LinkedList<TreeNode> getVertices() {
        return vertices;
    }

    public void addNode(TreeNode node) {
        node.parent.addChild(node);
        vertices.add(node);
        System.out.println("[SUCCESS] A new node has been successfully added to the tree!");
        size++;
        taskLevelCounter[node.level - 1]++;
    }

    public void removeNode(TreeNode node) {
        if (!vertices.contains(node)) {
            System.out.println("[FAILURE] Sorry, no node with those details could be found!");
        } else if (node.numOfChildren != 0) {
            System.out.println("[FAILURE] Sorry, the node you are trying to remove has some children associated to it!");
        } else {
            node.parent.removeChild(node);
            vertices.remove(node);
            System.out.println("[SUCCESS] Node has been successfully removed!");
            size--;
            taskLevelCounter[node.level - 1]--;
        }
    }

    public int size() {
        System.out.println("[INFO] The tree has a total of " + size + " nodes.");
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isExternal(TreeNode node) throws IndexOutOfBoundsException {
        if (!vertices.contains(node)) {
            System.out.println("[ERROR] Sorry the node can not be found inside of the tree!");
            return false;
        } else {
            boolean returnValue = (node.numOfChildren == 0);
            System.out.println("[INFO] External node? " + returnValue + ".");
            return returnValue;
        }
    }

    public boolean isInternal(TreeNode node) throws IndexOutOfBoundsException {
        if (!vertices.contains(node)) {
            System.out.println("[ERROR] Sorry the node can not be found inside of the tree!");
            return false;
        } else {
            boolean returnValue = (node.numOfChildren != 0);
            System.out.println("[INFO] Internal node? " + returnValue + ".");
            return returnValue;
        }
    }

    public boolean isRoot(TreeNode node) {
        return root == node;
    }

    public void eachLevelTask() {
        System.out.println("Tasks based on importance:");
        System.out.println("\tLevel 1: " + taskLevelCounter[0] + ".");
        System.out.println("\tLevel 2: " + taskLevelCounter[1] + ".");
        System.out.println("\tLevel 3: " + taskLevelCounter[2] + ".");
        System.out.println("\tLevel 4: " + taskLevelCounter[3] + ".");
        System.out.println("\tLevel 5: " + taskLevelCounter[4] + ".");
        System.out.println("\tLevel 6: " + taskLevelCounter[5] + ".");
        System.out.println("\tLevel 7: " + taskLevelCounter[6] + ".");
        System.out.println("\tLevel 8: " + taskLevelCounter[7] + ".");
        System.out.println("\tLevel 9: " + taskLevelCounter[8] + ".");
        System.out.println("\tLevel 10: " + taskLevelCounter[9] + ".");
        System.out.println("\tLevel 11: 1.");
    }

    public void print() {
        root.print();
        for (TreeNode vertex: vertices) {
            vertex.print();
        }
    }
}

class TreeNode {
    protected TreeNode parent;
    protected LinkedList<TreeNode> children;
    protected String task;
    protected int level;
    protected int numOfChildren;

    public TreeNode(TreeNode parent, String task, int level) {
        this.parent = parent;
        children = new LinkedList<>();
        this.task = task;
        this.level = level;
    }

    public void addChild(TreeNode child) {
        children.add(child);
        System.out.println("[SUCCESS] Child has been successfully added!");
        numOfChildren++;
    }

    public void removeChild(TreeNode child) {
        if (!children.contains(child)) {
            System.out.println("[FAILURE] Sorry, no child with those details could be found!");
        } else if (child.numOfChildren != 0) {
            System.out.println("[FAILURE] Sorry, the node you are trying to remove has some children associated to it!");
        } else {
            children.remove(child);
            System.out.println("[SUCCESS] Child has been successfully removed!");
            numOfChildren--;
        }
    }

    public void print() {
        System.out.println("---------------------------");
        if (parent == null) {
            System.out.println("Parent:\n\tIt is a root, so no parent.\nChildren:");
        } else {
            System.out.println("Parent:\n\t" + parent.task + ".\nChildren:");
        }
        if (numOfChildren == 0) {
            System.out.println("\tNO CHILDREN.");
        } else {
            for (TreeNode child : children) {
                System.out.println("\t" + child.task);
            }
        }
        System.out.println("Task:\n\t" + task + ".\nImportance Level:\n\t" + level);
        System.out.println("---------------------------");
    }
}
