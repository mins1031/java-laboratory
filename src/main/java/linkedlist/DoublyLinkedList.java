package linkedlist;

import java.util.List;

public class DoublyLinkedList<T> {

    private DoublyListNode<T> head = null;
    private DoublyListNode<T> tail = null;
    private int size;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int size) {
        this.head = null;
        this.tail = null;
        this.size = size;
    }

    public DoublyListNode getHead() {
        return head;
    }

    public DoublyListNode<T> search(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index > size / 2) {
            DoublyListNode<T> n = this.tail;
            for (int i = size - 1; i > index; i--) {
                n = n.getPrev();
            }
            return n;
        } else {
            DoublyListNode<T> n = this.head;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n;
        }
    }
}
