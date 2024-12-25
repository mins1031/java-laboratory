package java_cote.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParcelBox {
//    public int solution(int[] order) {
//        int answer = 0;
//        Stack<Integer> subContainerBelt = new Stack<>();
//        Queue<Integer> mainContainerBelt = new LinkedList<>();
//        for (int i = 0; i < order.length; i++) {
//            mainContainerBelt.add(i+1);
//        }
//
//        int orderIndex = 0;
//        while (true) {
//            if (orderIndex >= order.length) {
//                break;
//            }
//
//            int target = order[orderIndex];
//            if (mainContainerBelt.isEmpty()) {
//                if (isStopCondition(target, subContainerBelt, orderIndex, order.length)) {
//                    break;
//                }
//
//                subContainerBelt.pop();
//                orderIndex++;
//                answer++;
//                continue;
//            }
//
//            Integer mainPeek = mainContainerBelt.peek();
//            if (mainPeek > target) {
//                if (isStopCondition(target, subContainerBelt, orderIndex, order.length)) {
//                    break;
//                }
//
//                subContainerBelt.pop();
//                orderIndex++;
//                answer++;
//                continue;
//            }
//
//            if (mainPeek < target) {
//                subContainerBelt.add(mainContainerBelt.poll());
//                continue;
//            }
//
//            mainContainerBelt.poll();
//            orderIndex++;
//            answer++;
//        }
//
//        return answer;
//    }


    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subContainerBelt = new Stack<>();
        Queue<Integer> mainContainerBelt = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            mainContainerBelt.add(i+1);
        }

        int orderIndex = 0;
        while (true) {
            if (orderIndex >= order.length) {
                break;
            }
            int target = order[orderIndex];

            if (mainContainerBelt.isEmpty()) {
                if (isStopCondition(target, subContainerBelt)) {
                    break;
                }

                subContainerBelt.pop();
                orderIndex++;
                answer++;
                continue;
            }

            Integer mainPeek = mainContainerBelt.peek();
            if (mainPeek > target) {
                if (isStopCondition(target, subContainerBelt)) {
                    break;
                }

                subContainerBelt.pop();
                orderIndex++;
                answer++;
                continue;
            }

            if (mainPeek < target) {
                subContainerBelt.add(mainContainerBelt.poll());
                continue;
            }

            mainContainerBelt.poll();
            orderIndex++;
            answer++;
        }

        return answer;
    }

    public boolean isStopCondition(int target, Stack<Integer> subContainerBelt) {
        boolean isSubEmpty = subContainerBelt.isEmpty();
        boolean isSubPeekNotTarget = subContainerBelt.peek() != target;

        return isSubEmpty || isSubPeekNotTarget;
    }


    public static void main(String[] args) {
        int[] orders = {4, 3, 1, 2, 5};
//        int[] orders = {5, 4, 3, 2, 1};
        ParcelBox parcelBox = new ParcelBox();
        System.out.println(parcelBox.solution(orders));
    }
}
