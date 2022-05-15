package programmers.datastructure;

import java.util.LinkedList;

public class BDfsNode {
    private int data;
    private LinkedList<BDfsNode> childNodes;
    boolean marked;

    public BDfsNode(int data) {
        this.data = data;
        this.childNodes = new LinkedList<>();
        this.marked = false;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedList<BDfsNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(LinkedList<BDfsNode> childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
