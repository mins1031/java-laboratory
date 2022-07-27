package linkedlist;

public class DoublyListNode<T> {
    private T data;
    private DoublyListNode<T> next = null;
    private DoublyListNode<T> prev = null;

    public DoublyListNode() {
    }

    public DoublyListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public DoublyListNode<T> getNext() {
        return next;
    }

    public DoublyListNode<T> getPrev() {
        return prev;
    }
}

