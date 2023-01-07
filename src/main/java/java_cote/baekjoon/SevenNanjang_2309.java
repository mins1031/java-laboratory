package java_cote.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SevenNanjang_2309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> heights = new ArrayList<>();
        int nanjangCount = 9;
        int resultHeight = 100;
        for (int i = 0; i < nanjangCount; i++) {
            heights.add(Integer.valueOf(scanner.nextLine()));
        }

        int inputHeightSum = heights.stream().mapToInt(Integer::intValue).sum();

        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < nanjangCount - 2; i++) {
            for (int j = i +1 ; j < nanjangCount; j++) {
                int targetValue = heights.get(i) + heights.get(j);
                if (inputHeightSum - targetValue == resultHeight) {
                    x1 = i;
                    y1 = j;
                }
            }
        }

        Integer resultX1 = heights.get(x1);
        Integer resultY1 = heights.get(y1);

        heights.remove(resultX1);
        heights.remove(resultY1);

        heights.stream().sorted().forEach(System.out::println);
    }
}
