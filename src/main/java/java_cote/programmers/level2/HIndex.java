package java_cote.programmers.level2;

import java.util.Arrays;

public class HIndex {
    //1. 오름차순 정렬
    //2. 현재 인덱스 값과 남은 값의 배열의 길이가 같을때 까지 반복
    public int solution(int[] citations) {
        int answer = 0;


        int[] ints = Arrays.stream(citations).sorted().toArray();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= ints.length - i) {
                answer = ints.length - i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] citations = {3, 0, 6, 1, 5};
//        int [] citations = {5, 6, 7, 8};

        HIndex hIndex = new HIndex();
        int solution = hIndex.solution(citations);

        System.out.println(solution);
    }
}
