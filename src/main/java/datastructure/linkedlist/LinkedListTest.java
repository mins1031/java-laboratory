package datastructure.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(7);
        node.append(5);
        node.append(3);
        node.retrieve();
        node.delete(5);
        node.retrieve();
        List<String> list = new LinkedList<>();
    }

}
