package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tangerine {
    //경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는
    //귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
    //예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다.
    // 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
    //경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요

    //1. 해시맵으로 귤종류-카운트 맵핑 작업할것. 10,000,000 = n 임
    //2. 카운트 많은 종류순으로 정렬
    //3. 맵돌며 이전 카운트값 + 현카운트값이 k값을 넘지 안넘는지 확인 하며 result +1후 넘지 않았으면 다음 루프, 넘었다면 루프종료후 result return
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangCountByTypeMap = mapTangTypeAndCount(tangerine);
        int totalCount = 0;
        for (Integer count : tangCountByTypeMap.values()) {
            totalCount += count;
            answer += 1;
            if (totalCount >= k) {
                break;
            }
        }
        return answer;
    }

    private Map<Integer, Integer> mapTangTypeAndCount(int[] tangerine) {
        Map<Integer, Integer> tangCountByTypeMap = new HashMap<>();
        for (int i : tangerine) {
            tangCountByTypeMap.put(i, tangCountByTypeMap.getOrDefault(i, 0) + 1);
        }

        return sortByValueDescending(tangCountByTypeMap);
    }

    public Map<Integer, Integer> sortByValueDescending(Map<Integer, Integer> map) {
        // Convert map to list of map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort list by value in descending order
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Create a new LinkedHashMap to store the sorted entries
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }


    public static void main(String[] args) {
        int k = 6;
        int [] tangerines = {1, 3, 2, 5, 4, 5, 2, 3};
        Tangerine tangerine = new Tangerine();
        System.out.println(tangerine.solution(k, tangerines));
    }
}
