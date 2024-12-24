package java_cote.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class TakeLand {
    public static class Node {
        private int x;
        private int y;
        private int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    int solution(int[][] land) {
        int answer = 0;
        int depth = land.length;
        boolean [][] mem = new boolean[land.length][4];

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(0, 0, 0));
        nodes.add(new Node(0, 1, 0));
        nodes.add(new Node(0, 2, 0));
        nodes.add(new Node(0, 3, 0));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.x == depth) {
                answer = Math.max(node.value, answer);
                continue;
            }

            int value = node.value + land[node.x][node.y];

            for (int i = 0; i < 4; i++) {
                if (node.y == i) {
                    continue;
                }

                nodes.add(new Node(node.x + 1, i, value));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        TakeLand takeLand = new TakeLand();
        System.out.println(takeLand.solution(land));
    }
}
