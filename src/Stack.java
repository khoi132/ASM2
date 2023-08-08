public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(char item) {
        try {
            if (!isFull()) {
                stackArray[++top] = item;
            } else {
                throw new IllegalStateException("Stack is full.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public char pop() {
        try {
            if (!isEmpty()) {
                return stackArray[top--];
            } else {
                throw new IllegalStateException("Stack is empty.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return '\0';
        }
    }
}
