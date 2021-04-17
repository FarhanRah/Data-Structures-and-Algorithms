public class Heap {
    private QueueNode[] heapArr;
    private int size = 0;

    public Heap(Tree myTree) {
        heapArr = new QueueNode[myTree.size()];
        QueueNode temp = new QueueNode(myTree.getRoot().task, myTree.getRoot().level);
        heapArr[0] = temp;
        size++;

        int i = 1;
        for (TreeNode vertex: myTree.getVertices()) {
            temp = new QueueNode(vertex.task, vertex.level);
            heapArr[i] = temp;
            upHeapBubbling(size);
            size++;
            i++;
        }
    }

    public void upHeapBubbling(int index) {
        while (heapArr[index].level > heapArr[(index - 1) / 2].level) {
            QueueNode temp = heapArr[index];
            heapArr[index] = heapArr[(index - 1) / 2];
            heapArr[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }
    }

    public void downHeapBubbling(int index) {
        int swapChild;

        while (index <= size - 1) {
            int leftChild = (2 * index) + 1;
            int rightChild = (2 * index) + 2;
            if (leftChild <= size - 1) {
                if (rightChild > size - 1) {
                    swapChild = leftChild;
                }
                else {
                    swapChild = (heapArr[leftChild].level > heapArr[rightChild].level ? leftChild : rightChild);
                }

                if (heapArr[index].level < heapArr[swapChild].level) {
                    QueueNode temp = heapArr[index];
                    heapArr[index] = heapArr[swapChild];
                    heapArr[swapChild] = temp;
                }
                else {
                    break;
                }

                index = swapChild;
            }
            else {
                break;
            }
        }
    }

    public void addEntry(TreeNode entry) {
        if (size == heapArr.length) {
            QueueNode[] newArr = new QueueNode[size * 2];
            for (int i = 0; i < heapArr.length; i++) {
                newArr[i] = heapArr[i];
            }
            heapArr = newArr;
        }

        QueueNode temp = new QueueNode(entry.task, entry.level);
        heapArr[size] = temp;
        upHeapBubbling(size);
        size++;
    }

    public QueueNode getEntry() {
        QueueNode entryToBeReturned = null;
        if (size == 0) {
            System.out.println("[FAILURE] Sorry, the heap is completely, add something first!");
        } else {
            entryToBeReturned = heapArr[0];
        }

        return entryToBeReturned;
    }

    public QueueNode removeEntry() {
        QueueNode returnValue;

        if (size == 0) {
            System.out.println("[FAILURE] Sorry, the heap is empty, there is nothing to remove!");
            returnValue = null;
        } else {
            returnValue = heapArr[0];
            heapArr[0] = heapArr[size - 1];
            heapArr[size - 1] = null;
            size--;
            downHeapBubbling(0);
        }

        return returnValue;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                heapArr[i].print();
                System.out.print(" --> ");
            } else {
                heapArr[i].print();
                System.out.println();
            }
        }
    }
}
