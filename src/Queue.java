public class Queue {
    private int maxSize;
    private char[] queueArray;
    private int front;
    private int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new char[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    public boolean isEmpty() {
        return (front > rear);
    }

    public void enqueue(char item) {
        try {
            if (!isFull()) {
                queueArray[++rear] = item;
            } else {
                throw new IllegalStateException("Queue is full.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public char dequeue() {
        try {
            if (!isEmpty()) {
                char item = queueArray[front++];
                return item;
            } else {
                throw new IllegalStateException("Queue is empty.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return '\0';
        }
    }
}
