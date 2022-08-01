package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class LottoMaxMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer, Integer> ranking = new HashMap<>();
        ranking.put(6, 1);
        ranking.put(5, 2);
        ranking.put(4, 3);
        ranking.put(3, 4);
        ranking.put(2, 5);
        ranking.put(1, 6);
        ranking.put(0, 6);

        long matchCount = Arrays.stream(win_nums).filter(win_num -> Arrays.stream(lottos).anyMatch(lotto -> lotto == win_num)).count();
        long zeroCount = Arrays.stream(lottos).filter(l -> l == 0).count();
        int max = (int) (matchCount + zeroCount);
        int[] answer = {ranking.get(max <= 6 ? max : 6), ranking.get((int) matchCount)};
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};

        int[] solution = new LottoMaxMin().solution(lottos, winNums);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
