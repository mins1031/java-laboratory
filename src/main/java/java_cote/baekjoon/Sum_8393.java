package java_cote.baekjoon;

import java.util.Scanner;

public class Sum_8393 {
    public Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Sum_8393 sum_8393 = new Sum_8393();
        String input = sum_8393.scanner.nextLine();
        int result = 0;
        for (int index = 1; index <= Integer.valueOf(input); index++) {
            result += index;
        }

        System.out.println(result);
    }
}
