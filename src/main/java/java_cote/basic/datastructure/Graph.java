package java_cote.basic.datastructure;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    BDfsNode[] nodes;

    public Graph(int size) {
        this.nodes = new BDfsNode[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new BDfsNode(i);
        }
    }

    public void addEdge(int i1, int i2) {
        BDfsNode n1 = nodes[i1];
        BDfsNode n2 = nodes[i2];
        if (!n1.getChildNodes().contains(n2)) {
            n1.getChildNodes().add(n2);
        }

        if (!n2.getChildNodes().contains(n1)) {
            n2.getChildNodes().add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        BDfsNode root = nodes[index];
        Stack<BDfsNode> stack = new Stack<BDfsNode>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            BDfsNode r = stack.pop();
            for (BDfsNode bDfsNode : r.getChildNodes()) {
                if (bDfsNode.marked == false) {
                    bDfsNode.marked = true;
                    stack.push(bDfsNode);
                }
            }
            visit(r);
        }
    }

    void dfsR(BDfsNode node) {
        if (node == null) {return;}
        node.marked = true;
        visit(node);
        for (BDfsNode bDfsNode : node.getChildNodes()) {
            if (bDfsNode.marked == false) {
                dfsR(bDfsNode);
            }
        }
    }

    void dfsR(int index) {
        BDfsNode r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        BDfsNode root = nodes[index];
        Queue<BDfsNode> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            BDfsNode r = queue.poll();
            for (BDfsNode bDfsNode : r.getChildNodes()) {
                if (bDfsNode.marked == false) {
                    bDfsNode.marked = true;
                    queue.add(bDfsNode);
                }
            }
        visit(r);
        }
    }

    void visit(BDfsNode n) {
        System.out.print(n.getData() + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
//        graph.dfs();
//        graph.bfs();
//        graph.dfsR();
//        graph.dfs(3);
        graph.dfsR(3);
    }
}

