package java_lab.datastructure.queue;

public class QueueNode {
    private int value;
    private QueueNode nextNode;

    public QueueNode(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }

    public QueueNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(QueueNode nextNode) {
        this.nextNode = nextNode;
    }
}
