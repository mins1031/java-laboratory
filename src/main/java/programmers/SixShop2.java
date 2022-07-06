package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SixShop2 {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private Map<Integer, String> map = new TreeMap<>();

    public int solution(int k, String[] userScores) {
        int answer = 0;
        for (String userScore : userScores) {
            String[] temp = userScore.split(" ");
            String userName = temp[0];
            Integer score = Integer.valueOf(temp[1]);
            if (map.size() < k) {
                map.put(score, userName);
                priorityQueue.add(score);
                continue;
            }

            Integer minScore = priorityQueue.peek();
            if (!map.values().contains(userName) && minScore < score) {
                priorityQueue.add(score);
                priorityQueue.poll();
                map.put(score, userName);
                map.remove(minScore);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] userScores = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110",};
        int k = 3;

        System.out.println(new SixShop2().solution(k, userScores));

//        int[] estimates2 = {10, 1, 10, 1, 1, 4, 3, 10};
//        int k2 = 6;

    }
}
