package java_cote.programmers.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AlmostBigInteger {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining()).replaceAll("^0+", "0");
    }

    public static void main(String[] args) {
        AlmostBigInteger almostBigInteger = new AlmostBigInteger();
        int[] numbers = {3, 30, 34, 5, 9};
        String solution = almostBigInteger.solution(numbers);
        System.out.println(solution);
    }
}
