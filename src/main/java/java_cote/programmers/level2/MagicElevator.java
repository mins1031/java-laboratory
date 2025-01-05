package java_cote.programmers.level2;

import java.util.Stack;

public class MagicElevator {
    public static class Node{
        private final int presentFloor;
        private final int depth;

        public Node(int presentFloor, int depth) {
            this.presentFloor = presentFloor;
            this.depth = depth;
        }
    }

    public int solution(int storey) {
        int answer = storey;
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(storey, 0));

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop.presentFloor == 0) {
                answer = Math.min(pop.depth, answer);
                continue;
            }

            if (pop.depth >= answer) {
                continue;
            }

            stack.add(new Node(pop.presentFloor + 1, pop.depth + 1));
            stack.add(new Node(pop.presentFloor - 1, pop.depth + 1));
            stack.add(new Node(pop.presentFloor + 10, pop.depth + 1));
            stack.add(new Node(pop.presentFloor - 10, pop.depth + 1));
            stack.add(new Node(pop.presentFloor + 100, pop.depth + 1));
            stack.add(new Node(pop.presentFloor - 100, pop.depth + 1));
        }

        return answer != 0 ? answer : 0;
    }

    public static void main(String[] args) {
        int storey = 16;
        MagicElevator magicElevator = new MagicElevator();
        int solution = magicElevator.solution(storey);
        System.out.println(solution);
    }
}
