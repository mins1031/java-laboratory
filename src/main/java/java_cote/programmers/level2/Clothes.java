package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;// 각 의상의 경우의수들을 구하려면 의상별 (카운트 + 안입는 경우 = 1)을 곱해줘야함.
        }
        return answer-1; // 모든옷을 안입는 경우를 빼주기 위해 -1 한거라고함.
    }

    public static void main(String[] args) {
        Clothes clothes1 = new Clothes();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
        System.out.println(clothes1.solution(clothes));

//        int solution = clothes1.solution(clothes);
//        System.out.println(solution);

//        int[] arr = {1,2,3,4};
//        boolean[] visited = new boolean[4];
//        clothes1.combination(arr, visited, 0, 4, 2);
    }
}
