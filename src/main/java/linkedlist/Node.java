package linkedlist;

public class Node {

    private int data;

    private Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public boolean append(int data) {
        try {
            Node end = new Node(data);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete (int data) {
        Node n = this;
        while (n.next != null) {
            if (n.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
