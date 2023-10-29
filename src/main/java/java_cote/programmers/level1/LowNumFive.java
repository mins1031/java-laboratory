package java_cote.programmers.level1;

import java.util.Arrays;

public class LowNumFive {
    public int[] solution(int[] numList) {
        return Arrays.stream(numList).sorted().limit(5).toArray();
    }

    public static void main(String[] args) {
        int[] numList = {12, 4, 15, 46, 38, 1, 14};
        int[] solution = new LowNumFive().solution(numList);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
