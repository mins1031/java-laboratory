package java_cote.real_cote;

import java.util.LinkedList;
import java.util.Queue;

public class SixShop1 {

    private Queue<Integer> queue = new LinkedList<>();

    public int solution(int[] estimates, int k) {
        int answer = 0;
        int tempSum = 0;
        for (int estimate : estimates) {
            queue.add(estimate);
            tempSum += estimate;
            if (queue.size() < k) {
                continue;
            }

            if (answer < tempSum) {
                answer = tempSum;
            }

            tempSum -= queue.element();
            queue.remove();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] estimates = {5, 1, 9, 8, 10, 5};
        int k = 3;

        int[] estimates2 = {10, 1, 10, 1, 1, 4, 3, 10};
        int k2 = 6;

        System.out.println(new SixShop1().solution(estimates, k));
        System.out.println(new SixShop1().solution(estimates2, k2));
    }
}
