package java_cote.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 해야할거?
 * 1. 다리에서 언제 나오냐? -> 계속 큐에서 poll 해줘야함.
 *   1-1 poll 결과가 0 이면 2 번으로 진행
 *   1-2 poll 결과가 0이 아니면 다리무게 - poll 후 2 번으로 진행
 * 2. 트럭이 다리에 올라가냐 못올라가냐. (시간은 그대로 증가)
 *   2-1 (다리 현 무게 + 대기트럭 무게) <= 버티는 무게  ---> 올라감, 다리 무게 + 트럭 무게, 트럭인덱스++
 *   2-2 (다리 현 무게 + 대기트럭 무게) > 버티는 무게  ---> 대기.
 */

public class BridgeBetweenTruck {

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0; // 얘는 큐에 들어가면 + 1 , 무게 초과로 유지면 같이 유지

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridgeLength; i++) {
            queue.add(0);
        }

        while (true) {
            if (truckIndex >= truckWeights.length) {
                break;
            }

            Integer poll = queue.poll();
            if (poll != 0) {
                currentWeight -= poll;
            }

            int truckWeight = truckWeights[truckIndex];
            if ((currentWeight + truckWeight) > weight) {
                queue.add(0);
                time++;
                continue;
            }

            queue.add(truckWeight);
            currentWeight += truckWeight;
            truckIndex++;
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7,4,5,6};

        BridgeBetweenTruck target = new BridgeBetweenTruck();
        int solution = target.solution(bridgeLength, weight, truckWeights);
        System.out.println(solution);
    }
}
