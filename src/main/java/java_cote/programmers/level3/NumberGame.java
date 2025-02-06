package java_cote.programmers.level3;

import java.util.PriorityQueue;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> AHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> BReverseHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> BUpHeap = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            AHeap.add(A[i]);
            BReverseHeap.add(B[i]);
            BUpHeap.add(B[i]);
        }

        int answer = 0;

        while (!AHeap.isEmpty()) {
            Integer aPoll = AHeap.poll();
            Integer bReversePeek = BReverseHeap.peek();

            if (bReversePeek > aPoll) {
                BReverseHeap.poll();
                BUpHeap.remove(bReversePeek);
                answer += 1;
                continue;
            }

            Integer bUpPoll = BUpHeap.poll();
            if (bUpPoll > aPoll) {
                answer += AHeap.size() + 1;
                break;
            }

            BReverseHeap.remove(bUpPoll);
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] A = {7,6,2,5,3,4};
//        int[] B = {1,5,6,5,1,8};
//        int[] A = {5,1,3,7};
//        int[] B = {2,2,6,8};
        int[] A = {2,2,2,2};
        int[] B = {1,1,1,1};

        NumberGame numberGame = new NumberGame();
        int solution = numberGame.solution(A, B);
        System.out.println(solution);
    }
}
