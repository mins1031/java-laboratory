package java_cote.programmers.level1;

import java.util.Arrays;

public class ArrayAvg {
    public double solution(int[] arr) {
        int length = arr.length;
        int sum = Arrays.stream(arr).sum();
        return (double) sum / length;
    }

    public double solution2(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double solution = new ArrayAvg().solution(arr);
        double solution2 = new ArrayAvg().solution2(arr);
        System.out.println(solution);
        System.out.println(solution2);
    }
}
