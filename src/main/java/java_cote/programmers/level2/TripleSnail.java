package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class TripleSnail {
    public static class Node{
        private final int value;
        private final int targetX;
        private final int targetY;

        public Node(int value, int targetX, int targetY) {
            this.value = value;
            this.targetX = targetX;
            this.targetY = targetY;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", targetX=" + targetX +
                    ", targetY=" + targetY +
                    '}';
        }
    }

    public enum Direction {
        DOWN,
        RIGHT,
        UP
    }

    public int[] solution(int n) {
        int [][] snailPath = new int[n][n];
        initSnailPath(n, snailPath);
        List<Node> nodes = new ArrayList<>();

        int forwardCount = n;
        int oneDirectionForwardCount = 0;
        Direction presentDirection = Direction.DOWN;
        int presentX = -1;
        int presentY = 0;
        int presentValue = 0;

        while (forwardCount > 0) {
            if (Direction.DOWN.equals(presentDirection)) {
                presentX++;
                presentValue++;

                nodes.add(new Node(
                        presentValue,
                        presentX,
                        presentY
                ));
                oneDirectionForwardCount++;
            }

            if (Direction.RIGHT.equals(presentDirection)) {
                presentY++;
                presentValue++;

                nodes.add(new Node(
                        presentValue,
                        presentX,
                        presentY
                ));
                oneDirectionForwardCount++;
            }

            if (Direction.UP.equals(presentDirection)) {
                presentX--;
                presentY--;
                presentValue++;

                nodes.add(new Node(
                        presentValue,
                        presentX,
                        presentY
                ));
                oneDirectionForwardCount++;
            }

            if (oneDirectionForwardCount == forwardCount) {
                forwardCount--;
                oneDirectionForwardCount = 0;
                presentDirection = nextDirection(presentDirection);
            }
        }

        for (Node node : nodes) {
            snailPath[node.targetX][node.targetY] = node.value;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (snailPath[i][j] == 0) {
                    continue;
                }

                answer.add(snailPath[i][j]);
            }
        }


        return answer.stream().mapToInt(d -> d).toArray();
    }

    private Direction nextDirection(Direction presentDirection) {
        if (Direction.DOWN.equals(presentDirection)) {
            return Direction.RIGHT;
        }

        if (Direction.RIGHT.equals(presentDirection)) {
            return Direction.UP;
        }

        return Direction.DOWN;
    }

    private void initSnailPath(int n, int[][] snailPath) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                snailPath[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        TripleSnail tripleSnail = new TripleSnail();
        int[] solution = tripleSnail.solution(n);
        for (int i : solution) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
}
