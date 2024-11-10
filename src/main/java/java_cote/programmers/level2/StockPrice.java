package java_cote.programmers.level2;

import java.util.Stack;

public class StockPrice {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                stack.push(0);
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            Integer stackFirstIndex = stack.peek();
            if (prices[i] >= prices[stackFirstIndex]) {
                stack.push(i);
                continue;
            }

            int size = stack.size();
            if (prices[i] < prices[stackFirstIndex]) {
                for (int j = 0; j < size; j++) {
                    if (stack.isEmpty() || prices[i] >= prices[stack.peek()]) {
                        break;
                    }

                    Integer popIndex = stack.pop();
                    result[popIndex] = i - popIndex;
                }

                stack.push(i);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            Integer integer = stack.get(i);
            result[integer] = (length - 1) - integer;
        }

        return result;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] array = {3, 5, 2, 6, 7, 8, 1, 10, 9};
        int[] solution = stockPrice.solution(array);
        for (int i : solution) {
            System.out.print(i + ", ");
        }
    }
}
