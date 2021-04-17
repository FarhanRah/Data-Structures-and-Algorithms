import java.util.Stack;

class Queue {

    private Stack<String> firstStack = new Stack<>();
    private Stack<String> secondStack = new Stack<>();
    private int size = 0;

    public void enqueue(String entry) {
        firstStack.push(entry);
        size++;
    }

    public String dequeue() {
        try {
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                throw new Exception("Both stacks are empty!");
            }

            if (secondStack.isEmpty()) {
                int x = firstStack.size();
                for (int i = 0; i < x; i++) {
                    secondStack.push(firstStack.pop());
                }
            }
        } catch(Exception error) {
            System.out.println("[QUEUE ERROR] Both the stacks (Stack1 and Stack2) are empty!");
        }

        size--;
        return secondStack.pop();
    }

    public String front() {
        try {
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                throw new RuntimeException("Both stacks are empty!");
            }

            if (secondStack.isEmpty()) {
                for (int i = 0; i < firstStack.size(); i++) {
                    secondStack.push(firstStack.pop());
                }
            }
        } catch(RuntimeException error) {
            System.out.println("[QUEUE ERROR] Both the stacks (Stack1 and Stack2) are empty!");
        }

        return secondStack.peek();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
