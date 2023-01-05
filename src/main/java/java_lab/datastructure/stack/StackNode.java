package java_lab.datastructure.stack;

public class StackNode <T> {
    private T value;
    private StackNode<T> next;

    public StackNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
