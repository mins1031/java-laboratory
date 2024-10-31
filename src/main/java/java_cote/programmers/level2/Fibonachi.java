package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Fibonachi {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        List<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);

        for (int i = 2; i <= n; i++) {
            Integer firstElement = memo.get(i - 2)/* % 1234567*/;
            Integer secondElement = memo.get(i - 1)/* % 1234567*/;

            memo.add(firstElement + secondElement);
        }


        return memo.get(n) % 1234567;
    }


    public static void main(String[] args) {
        Fibonachi fibonachi = new Fibonachi();
        int n = 47;

        System.out.println(fibonachi.solution(n));
    }
}
