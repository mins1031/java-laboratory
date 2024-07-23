package java_cote.programmers.level2;

import java.util.Stack;

public class RightBracket {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack();
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.add(c);
                continue;
            }

            if (')' == c && stack.empty()) {
                stack.add(c);
                continue;
            }

            if (')' == c && '(' == stack.peek()) {
                stack.pop();
                continue;
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RightBracket rightBracket = new RightBracket();

        String first = "()()";
        boolean solution = rightBracket.solution(first);
        System.out.println(solution);

        String second = "(())()";
        boolean solution2 = rightBracket.solution(second);
        System.out.println(solution2);

        String third = ")()(";
        boolean solution3 = rightBracket.solution(third);
        System.out.println(solution3);

        String fourth = "(()(";
        boolean solution4 = rightBracket.solution(fourth);
        System.out.println(solution4);
    }
}
