package java_cote.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiscountParty {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int loopEndIndex = discount.length - 10;
        for (int i = 0; i <= loopEndIndex; i++) {
            Map<String, Integer> tempMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) + 1);
            }

            int matchCount = 0;
            for (Map.Entry<String, Integer> tempEntry : tempMap.entrySet()) {
                Integer value = map.get(tempEntry.getKey());
                Integer tempValue = tempEntry.getValue();
                if (Objects.equals(value, tempValue)) {
                    matchCount++;
                }
            }

            if (matchCount == want.length) {
                answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        DiscountParty discountParty = new DiscountParty();
        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] number = {3,2,2,2,1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int solution = discountParty.solution(want, number, discount);
        System.out.println(solution);
    }
}
