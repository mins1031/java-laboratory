package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class StringCompress {
    public List<String> split(String input, int depth) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i += depth) {
            int endIdx = i + depth;
            if (endIdx > input.length()) {
                endIdx = input.length();
            }
            tokens.add(input.substring(i, endIdx));
        }

        return tokens;
    }

    public int compress(String input, int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        String last = "";
        int count = 1;

        for (String splitResult : split(input, depth)) {
            if (last.equals(splitResult)) {
                count++;
            } else {
                if (count > 1) {
                    stringBuilder.append(count);
                }
                stringBuilder.append(last);
                last = splitResult;
                count = 1;
            }
        }

        if (count > 1) {
            stringBuilder.append(count);
        }
        stringBuilder.append(last);

        return stringBuilder.toString().length();
    }


    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            int min = compress(s, i);
            if (min < answer) {
                answer = min;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompress stringCompress = new StringCompress();
        String s = "a";
        System.out.println(stringCompress.solution(s));
    }
}
