package java_cote.programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class TwoPickAndAdd {

    public int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        int [] numbers = {2,1,3,4,1};
        int [] result = {2,3,4,5,6,7};
        int [] numbers2 = {5,0,2,7};
        int [] result2 = {2,5,7,9,12};

        TwoPickAndAdd twoPickAndAdd = new TwoPickAndAdd();
        int[] solution1 = twoPickAndAdd.solution(numbers);
        for (int i : solution1) {
            System.out.print(i);
        }
        System.out.println();

        int[] solution2 = twoPickAndAdd.solution(numbers2);
        for (int i : solution2) {
            System.out.print(i);
        }
    }
}
