package java_cote.programmers.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringDownSort {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        List<Integer> asciis = new ArrayList<>();
        for (char aChar : chars) {
            asciis.add((int) aChar);
        }

        int[] ints = asciis.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int integer : ints) {
            stringBuilder.append((char) integer);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringDownSort stringDownSort = new StringDownSort();
        String s = "Zbcdefg";
        String solution = stringDownSort.solution(s);
        System.out.println(solution);
    }
}
