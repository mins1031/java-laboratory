package java_cote.programmers.level2;

import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EngWordChain {

    // 개선 내용
    public int[] solution2(int n, String[] words) {
        int[] answer = { 0, 0 };
        char chEnd = words[0].charAt(words[0].length() - 1);
        char chStart;
        System.out.print(chEnd + " ");

        HashSet<String> log = new HashSet<>();
        log.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            chStart = words[i].charAt(0);
            log.add(words[i]);
            // HashSet을 통해서 미리 단어를 넣고 set의 사이즈가 i 랑 다를경우 중복으로 판단. -> 나는 map으로 단어 모두 넣어놓고 판단(속도 이슈로 hash를 생각했는데 set을 사용하니 굳이 이럴필요가 없었음.)
            if (chEnd != chStart || log.size() != i + 1) {
                System.out.print(i + 1 + "!");
                // 나는 모두 돌리고 나눠서 값을 구했는데.. 여기는 문제가 발생하는 순간 몇번째인지, 몇 루프 째인지 계산하기에 더 간단하게 작업할수 있음
                answer[0] = (i % n)+1;
                answer[1] = (i / n) + 1;
                break;
            }

            chEnd = words[i].charAt(words[i].length() - 1);
            System.out.print(chEnd + " ");
        }
        System.out.println();
        System.out.println("(" + answer[0] + ", " + answer[1] + ")");
        return answer;
    }

    public int[] solution(int n, String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, 0);
        }

        int count = 0;
        boolean isFail = true;

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                wordCountMap.put(words[i], 1);
                continue;
            }

            int wordCount = wordCountMap.get(words[i]);

            char beforeWordLastChar = words[i - 1].charAt(words[i - 1].length() - 1);
            char nowWordLastChar = words[i].charAt(0);

            if (beforeWordLastChar != nowWordLastChar || wordCount == 1 || words[i].length() == 1) {
                isFail = false;
                count = i + 1;
                break;
            }

            wordCountMap.put(words[i], wordCount + 1);
        }


        if (isFail) {
            return new int[]{0, 0};
        }

        int failPersonNum = count;

        if (count > n) {
            failPersonNum = count % n == 0 ? n : count % n;
        }

        int speakingCount = 1;

        if (count > n) {
            int temp = count / n;
            speakingCount = count % n == 0 ? temp: temp + 1;
        }


        return new int[]{failPersonNum, speakingCount};
    }

    public static void main(String[] args) {
        String[] strings1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] solution = new EngWordChain().solution(3, strings1);

        for (int i : solution) {
            System.out.println(i);
        }

        String[] strings2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int[] solution2 = new EngWordChain().solution(5, strings2);

        for (int i : solution2) {
            System.out.println(i);
        }

        String[] strings3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] solution3 = new EngWordChain().solution(2, strings3);
        for (int i : solution3) {
            System.out.println(i);
        }

        String[] strings4 = {"hello", "one", "even", "even", "now", "draw"};
        int[] solution4 = new EngWordChain().solution(4, strings4);
        for (int i : solution4) {
            System.out.println(i);
        }
    }
}
