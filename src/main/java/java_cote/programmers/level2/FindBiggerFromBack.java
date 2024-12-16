package java_cote.programmers.level2;

import java.util.Stack;

public class FindBiggerFromBack {
    public static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(0, numbers[0]));

        for (int i = 1; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.add(new Node(i, numbers[i]));
                continue;
            }

            Node peek = stack.peek();
            if (peek.value >= numbers[i]) {
                stack.add(new Node(i, numbers[i]));
                continue;
            }

            handleLesserThanPresentInStack(numbers[i], answer, stack);
            stack.add(new Node(i, numbers[i]));
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Node pop = stack.pop();
            answer[pop.index] = -1;
        }

        return answer;
    }

    private void handleLesserThanPresentInStack(int number, int[] answer, Stack<Node> stack) {
        while (
                !stack.isEmpty()
                        && stack.peek().value < number
        ) {
            Node pop = stack.pop();
            answer[pop.index] = number;
        }
    }

    public static void main(String[] args) {
        int [] numbers = {9, 1, 5, 3, 6, 2};
        FindBiggerFromBack findBiggerFromBack = new FindBiggerFromBack();
        int[] solution = findBiggerFromBack.solution(numbers);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
