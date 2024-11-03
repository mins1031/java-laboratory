package java_cote.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BracketReverse {
    private final List<String> openBrackets = List.of("[", "{", "(");
    private final List<String> closeBrackets = List.of("]", "}", ")");
    private final Map<String, String> bracketMaps = Map.of(
            "[", "]",
            "{", "}",
            "(", ")"
    );
    private Stack<String> openBracketStack = new Stack<>();

    public int solution(String s) {
        int answer = 0;
        String[] split = s.split("");
        LinkedList<String> bracketList = new LinkedList<>(Arrays.asList(split));
        int size = bracketList.size();

        for (int i = 0; i < size; i++) {
            if (calculate(bracketList)) {
                answer++;
            }

            exchangeFirstAndLast(bracketList);
        }

        return answer;
    }

    private void exchangeFirstAndLast(LinkedList<String> bracketList) {
        String first = bracketList.get(0);
        bracketList.removeFirst();
        bracketList.addLast(first);
    }

    private boolean calculate(List<String> bracketList) {
        for (String content : bracketList) {
            if (!openBrackets.contains(content) && !closeBrackets.contains(content)) {
                // 괄호가 아닌 값을 위해
                continue;
            }

            // 열린괄호면 스택에 저장후 다음루프 진행
            if (openBrackets.contains(content)) {
                openBracketStack.add(content);
                continue;
            }

            // 닫힌 괄혼데 스택에 저장된 열린 괄호가 없으면 해당 문자열은 실패
            if (openBracketStack.empty()) {
                return false;
            }

            String openBracket = openBracketStack.pop();
            if (!bracketMaps.get(openBracket).equals(content)) {
                return false;
            }
        }

        if (!openBracketStack.empty()) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        BracketReverse bracketReverse = new BracketReverse();
//        String bracket = "[](){}";
//        String bracket = "}]()[{";
        String bracket = "{{{";
        int solution = bracketReverse.solution(bracket);
        System.out.println(solution);
    }
}
