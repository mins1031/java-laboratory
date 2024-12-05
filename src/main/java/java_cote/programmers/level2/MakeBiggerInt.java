package java_cote.programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MakeBiggerInt {

    public String solution(String number, int k) {
        List<Integer> splitNumbers = Arrays.stream(number.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
        int totalStackCount = splitNumbers.size() - k;
        int popCount = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < splitNumbers.size(); i++) {
            if (popCount >= k) {
                stack.addAll(splitNumbers.subList(i, splitNumbers.size()));
                break;
            }

            if (stack.isEmpty()) {
                stack.add(splitNumbers.get(i));
                continue;
            }

            Integer compareValue = splitNumbers.get(i);
            Integer peekValue = stack.peek();
            if (peekValue >= compareValue) {
                stack.add(compareValue);
                continue;
            }

            while (true) {
                if (stack.isEmpty()) {
                    break;
                }

                if ((stack.size() + splitNumbers.size() - i) == totalStackCount) {
                    break;
                }

                if (stack.peek() >= compareValue) {
                    break;
                }

                stack.pop();
                popCount++;
            }

            stack.add(compareValue);
        }

        while (popCount < k) {
            stack.pop();
            popCount++;
        }

        StringBuilder answer = new StringBuilder();

        for (Integer integer : stack) {
            answer.append(integer);
        }

        return answer.toString();
    }


    public static void main(String[] args) {
        MakeBiggerInt makeBiggerInt = new MakeBiggerInt();
        String number = "4177252841";
        int k = 4;
//        String number = "10";
//        int k = 1;
        String solution = makeBiggerInt.solution(number, k);
        System.out.println(solution);
    }
}

//            if (queue.size() < totalQueueSize) {
//                queue.add(splitNumbers.get(i));
//                continue;
//            }
