package java_cote.programmers.level3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GemShopping {
    public int[] solution(String[] gems) {
        int minStartIndex = 0;
        int minEndIndex = Integer.MAX_VALUE;
        int gemCount = Arrays.stream(gems).collect(Collectors.toSet()).size();

        int presentStart = 0;
        int presentEnd = 1;
        while (presentEnd < gems.length) {
            if (gemCount == 1) {
                minStartIndex = 0;
                minEndIndex = 0;
                break;
            }

            Set<String> countFilter = new HashSet<>();
            for (int i = presentStart; i <= presentEnd; i++) {
                countFilter.add(gems[i]);
            }

            if (countFilter.size() != gemCount) {
                presentEnd++;
                continue;
            }

            int beforeValue = Math.abs(minEndIndex - minStartIndex);
            int presentValue = Math.abs(presentEnd - presentStart);
            if (presentValue < beforeValue) {
                minStartIndex = presentStart;
                minEndIndex = presentEnd;
            }

            while (true) {
                presentStart++;

                Set<String> startCountFilter = new HashSet<>();
                for (int i = presentStart; i <= presentEnd; i++) {
                    startCountFilter.add(gems[i]);
                }

                if (startCountFilter.size() == gemCount) {
                    int inBeforeValue = Math.abs(minEndIndex - minStartIndex);
                    int inPresentValue = Math.abs(presentEnd - presentStart);
                    if (inPresentValue < inBeforeValue) {
                        minStartIndex = presentStart;
                        minEndIndex = presentEnd;
                    }

                    continue;
                }

                presentEnd++;
                break;
            }
        }

        return new int[] {minStartIndex + 1, minEndIndex + 1};
    }
    //1. start와 end 변수를 가지고 작업.
    //2. start부터 end까지 값을 비교해 모든 종류 충족여부로 동작이 달라짐
    //2-1. start부터 end까지 값이 모든종류가 아닌경우
    //2-1-1. end값을 하나 늘리고 다음 루프 진행
    //2-2. start부터 end까지 값이 모든종류 인 경우
    //2-2-1. 이번엔 start를 계속 늘려가는 루프를 진행해야함 -> start 부터 end 까지 최소값 찾기위해서 -> 이게 적어도 n^2까지는 절대 안나오기 때문에 ㄱㅊ
    //2-2-1-1. start를 늘리고 start ~ end 비교해
    // 2-2-1-1-1. start부터 end까지 값이 모든종류가 아닌경우
    // 2-2-1-1-1-1. 루프 탈출후 end값 다시 증가
    // 2-2-1-1-2. start부터 end까지 값이 모든종류 인 경우
    // 2-2-1-1-2-1. 기존값과 비교한후 더 작은쪽을 답으로 처리
    // 2-2-1-1-2-1. start를 늘리고 루프 진행

    public static void main(String[] args) {
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}; // 3, 7
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"}; // 1, 3
//        String[] gems = {"XYZ", "XYZ", "XYZ"}; // 1, 1
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}; // 1, 5

        GemShopping gemShopping = new GemShopping();
        int[] solution = gemShopping.solution(gems);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
