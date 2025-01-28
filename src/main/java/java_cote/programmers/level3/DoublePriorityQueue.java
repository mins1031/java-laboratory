package java_cote.programmers.level3;

import java.util.Objects;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> normalQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>((a, b) -> b - a);

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            if ("I".equals(command)) {
                normalQueue.add(value);
                reverseQueue.add(value);
                continue;
            }

            if (value == -1) {
                Integer minValue = normalQueue.poll();
                reverseQueue.remove(minValue);
            } else {
                Integer maxValue = reverseQueue.poll();
                normalQueue.remove(maxValue);
            }
        }

        int min = Objects.isNull(normalQueue.peek()) ? 0 : normalQueue.peek();
        int max = Objects.isNull(reverseQueue.peek()) ? 0 : reverseQueue.peek();

        return new int[]{max, min};
    }

    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
        int[] solution = doublePriorityQueue.solution(operations);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
