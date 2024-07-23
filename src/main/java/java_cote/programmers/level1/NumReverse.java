package java_cote.programmers.level1;

import java.util.Arrays;

public class NumReverse {
    public int[] solution2(long n) {
        String nToString = Long.toString(n);

        String reversed = new StringBuilder(nToString).reverse().toString();
        char[] chars = reversed.toCharArray();

        int[] answer = new int[nToString.length()];
        for (int i = 0; i < chars.length; i++) {
            answer[i] = chars[i] - '0';
        }

        return answer;
    }

    public int[] solution(long n) {
        String nToString = String.valueOf(n);
        int[] answer = new int[nToString.length()];

        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder stringBuilder = new StringBuilder(nToString).reverse().toString();
        for (int i = nToString.length() - 1; i >= 0; i--) {
            int i1 = nToString.charAt(i) - '0';
            stringBuilder.append(i1);
        }

        String s = stringBuilder.toString();
        for (int i = 0; i < nToString.length(); i++) {
            answer[i] = s.charAt(i) - '0';
        }

        return answer;
    }

    public static void main(String[] args) {
        NumReverse numReverse = new NumReverse();
        long n = 12345;
        int[] solution = numReverse.solution2(n);
        System.out.println(Arrays.toString(solution));
    }
}
