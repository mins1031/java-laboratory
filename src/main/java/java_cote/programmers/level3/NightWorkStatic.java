package java_cote.programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NightWorkStatic {
    private static class Node {
        private int[] works;
        private int depth;

        public Node(int[] works, int depth) {
            this.works = works;
            this.depth = depth;
        }

        public int getSquareAllValue() {
            int firstSquare = works[0] * works[0];
            int secondSquare = works[1] * works[1];
            int thirdSquare = works[2] * works[2];

            return firstSquare + secondSquare + thirdSquare;
        }
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        Map<Integer, Boolean> mem = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(works, 0));

        while (!queue.isEmpty()) {
            Node peek = queue.peek();
            if (peek.depth == n) {
                int squareAllValue = peek.getSquareAllValue();
                answer = Math.min(answer, squareAllValue);
                continue;
            }

            //작업수당 한번씩 -1 처리해야함 for i in works.length
            int[] peekWorks = peek.works;
            for (int i = 0; i < peekWorks.length; i++) {
                int minusTargetWork = peekWorks[i] - 1;
                int[] nextWorks = new int[peekWorks.length];

                new Node(

                )
            }
            for (int work : peek.works) {

                new
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        int [] works = {4, 3, 3};
        int n = 4;

        NightWorkStatic nightWorkStatic = new NightWorkStatic();
        long solution = nightWorkStatic.solution(n, works);


        System.out.println(solution);

    }
}
