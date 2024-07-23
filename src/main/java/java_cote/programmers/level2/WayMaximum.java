package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WayMaximum {
    public long solution(String expression) {
        long answer = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> expTokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            expTokens.add(stringTokenizer.nextToken());
        }

        List<List<String>> expBundles = Arrays.asList(
                Arrays.asList("+", "-", "*"),
                Arrays.asList("+", "*", "-"),
                Arrays.asList("-", "+", "*"),
                Arrays.asList("-", "*", "+"),
                Arrays.asList("*", "-", "+"),
                Arrays.asList("*", "+", "-")
        );

        for (List<String> expBundle : expBundles) {
            long tempResult = Math.abs(calculatedResult(expTokens, expBundle));
            answer = Math.max(tempResult, answer);
        }

        return answer;
    }

    private long calculatedResult(List<String> expTokens, List<String> exps) {
        List<String> tempResult = new ArrayList<>(expTokens);

        for (String exp : exps) {
            for (int i = 0; i < tempResult.size(); i++) {
                if (!tempResult.get(i).equals(exp)) {
                    continue;
                }

                Long left = Long.parseLong(tempResult.get(i - 1));
                Long right = Long.parseLong(tempResult.get(i + 1));
                long calculateResult = calculate(left, right, exp);
                tempResult.remove(i - 1);
                tempResult.remove(i - 1);
                tempResult.remove(i - 1);
                tempResult.add(i - 1, String.valueOf(calculateResult));
                i -= 2;
            }
        }

        return Long.parseLong(tempResult.get(0));
    }

    public long calculate(long left, long right, String exp) {
        if (exp.equals("+")) return left + right;
        if (exp.equals("-")) return left - right;
        if (exp.equals("*")) return left * right;
        return 0;
    }



    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        WayMaximum wayMaximum = new WayMaximum();
        long solution = wayMaximum.solution(expression);
        System.out.println(solution);
    }
}
