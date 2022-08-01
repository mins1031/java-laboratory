package programmers.level1;

import java.util.Arrays;

public class AbsolutesChange {
    public int solution(int[] absolutes, boolean[] signs) {
        int size = absolutes.length;
        for (int i = 0; i < size; i++) {
            if (!signs[i]) {
                absolutes[i] *= -1;
            }
        }

        return Arrays.stream(absolutes).sum();
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        System.out.println(new AbsolutesChange().solution(absolutes, signs));
    }

}
