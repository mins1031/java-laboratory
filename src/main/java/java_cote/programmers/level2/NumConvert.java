package java_cote.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class NumConvert {
    public static class Node{
        private final int presentValue;
        private final int count;

        public Node(int presentValue, int count) {
            this.presentValue = presentValue;
            this.count = count;
        }
    }

    public int solution(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;
        boolean[] mem = new boolean[1000001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.presentValue > y || poll.count >= answer || mem[poll.presentValue]) {
                continue;
            }

            if (poll.presentValue == y) {
                answer = Math.min(poll.count, answer);
                continue;
            }

            mem[poll.presentValue] = true;

            int nextCount = poll.count + 1;
            queue.add(new Node(poll.presentValue + n, nextCount));
            queue.add(new Node(poll.presentValue * 2, nextCount));
            queue.add(new Node(poll.presentValue * 3, nextCount));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 17;
        int n = 3;

        NumConvert numConvert = new NumConvert();
        int solution = numConvert.solution(x, y, n);
        System.out.println(solution);
    }
}
