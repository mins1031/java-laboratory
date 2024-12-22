package java_cote.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class VowelSearch {
    public int solution(String word) {
        int answer = 0;
        String[] vowelArr = {"A", "E", "I", "O", "U"};

        Map<String, Integer> vowelMap = new HashMap<>();
        vowelMap.put("A", 0);
        vowelMap.put("E", 1);
        vowelMap.put("I", 2);
        vowelMap.put("O", 3);
        vowelMap.put("U", 4);

        Stack<String> tempWord = new Stack<>();
        tempWord.add("A");
        answer++;

        while (!tempWord.isEmpty()) {
            if (isEqualsWord(tempWord, word)) {
                break;
            }

            if (tempWord.size() == 5) {
                String peek = tempWord.peek();
                if (peek.equals("U")) {
                    while (tempWord.peek().equals("U")) {
                        tempWord.pop();
                    }
                    String pop = tempWord.pop();
                    tempWord.add(vowelArr[vowelMap.get(pop) + 1]);
                } else {
                    Integer vowelIndex = vowelMap.get(peek);
                    tempWord.pop();
                    tempWord.add(vowelArr[vowelIndex + 1]);
                }
            } else {
                tempWord.add("A");
            }

            answer++;
        }

        return answer;
    }

    public boolean isEqualsWord(Stack<String> tempWord, String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : tempWord) {
            stringBuilder.append(s);
        }

        return word.equals(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String target0 = "AAAAE";
        String target1 = "AAAE";
        String target2 = "I";
        String target3 = "EIO";

        VowelSearch vowelSearch = new VowelSearch();
        System.out.println(vowelSearch.solution(target0));
        System.out.println(vowelSearch.solution(target1));
        System.out.println(vowelSearch.solution(target2));
        System.out.println(vowelSearch.solution(target3));
    }
}
