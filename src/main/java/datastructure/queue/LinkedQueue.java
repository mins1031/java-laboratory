package datastructure.queue;

public class LinkedQueue {

    private QueueNode front;
    private QueueNode rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.front == null && this.rear == null && this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (this.front == null && this.rear == null && this.size == 0) {
            return 0;
        }

        return size;
    }

    public void push(int value) {
        QueueNode queueNode = new QueueNode(value);
        if (this.front == null && this.rear == null) {
            this.front = queueNode;
            this.rear = queueNode;
        } else {
            this.rear.setNextNode(queueNode);
            this.rear = queueNode;
        }
        size++;
    }

}
