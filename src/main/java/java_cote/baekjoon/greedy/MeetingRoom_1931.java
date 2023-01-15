package java_cote.baekjoon.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeetingRoom_1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> reservations = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tempInput = scanner.nextLine().split(" ");
            reservations.put(Integer.parseInt(tempInput[0]), Integer.parseInt(tempInput[1]));
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : reservations.entrySet()) {
            System.out.println(integerIntegerEntry);
        }
    }
}
