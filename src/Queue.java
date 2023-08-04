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
        if (!isFull()) {
            queueArray[++rear] = item;
        }
    }

    public char dequeue() {
        if (!isEmpty()) {
            char item = queueArray[front++];
            return item;
        }
        return '\0';
    }
}
