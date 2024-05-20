package java_cote.programmers.level2;

import java.util.Arrays;

public class LeastCommonMultiple {
//    public long nlcm(int[] num) {
//        long answer = num[0], g;
//        for (int i = 1; i < num.length; i++) {
//            g = gcd(answer, num[i]);
//            answer = g * (answer / g) * (num[i] / g);
//        }
//        return answer;
//    }

    public int solution(int[] arr) {
        int maxInt = Arrays.stream(arr).max().getAsInt();
        int count = 1;

        while (true) {
            int standLeastCommon = maxInt * count;
            boolean isNotLeastCommon = false;
            for (int i : arr) {
                if (isNotLeastCommon) {
                    break;
                }

                int result = standLeastCommon % i;
                if (result != 0) {
                    isNotLeastCommon = true;
                }
            }

            if (!isNotLeastCommon) {
                break;
            }

            count++;
        }

        return maxInt * count;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        int solution = new LeastCommonMultiple().solution(ints);
        System.out.println(solution);
    }
}
