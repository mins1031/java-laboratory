package java_cote.basic.datastructure;

public class LinkedList {
    private Node header;

    public LinkedList() {
        this.header = new Node();
    }

    public void append(int data) {
        Node end = new Node();
        end.setData(data);
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.getData() == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.getData() + "->");
            n = n.next;
        }
        System.out.println(n.getData());
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.retrieve();
        ll.delete(4);
        ll.retrieve();
    }
}
