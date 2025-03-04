package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class ReturnArmyPoint {
    public static class QueueWrapper{
        private Queue<Integer> queue;
        private Set<Integer> queueSet;

        public QueueWrapper() {
            this.queue = new LinkedList<>();
            this.queueSet = new HashSet<>();
        }

        public void add(Integer value) {
            if (queueSet.contains(value)) {
                return;
            }

            queue.add(value);
            queueSet.add(value);
        }

        public Integer poll() {
            Integer poll = queue.poll();
            queueSet.remove(poll);

            return poll;
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void clear() {
            this.queueSet.clear();
            this.queue.clear();
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answerList = new ArrayList<>();
        int[] sourceValues = new int[501];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            Set<Integer> firstValue = map.getOrDefault(road[0], new HashSet<>());
            firstValue.add(road[1]);
            map.put(road[0], firstValue);

            Set<Integer> secondValue = map.getOrDefault(road[1], new HashSet<>());
            secondValue.add(road[0]);
            map.put(road[1], secondValue);
        }

        for (int i = 0; i < sourceValues.length; i++) {
            sourceValues[i] = -2;
        }

        for (int source : sources) {
            if (destination == source) {
                sourceValues[source] = 0;
                continue;
            }
            if (Objects.isNull(map.get(source))) {
                sourceValues[source] = -1;
            }
        }

        Set<Integer> notDupleSources = Arrays.stream(sources).boxed().collect(Collectors.toSet());
        QueueWrapper queueWrapper = new QueueWrapper();
        queueWrapper.add(destination);

        // 맵에서 출발지 정보로 조회해서 리스트 돌려보고 목적지 있으면 뎁스 적용해서 큐비우고 탈출하고 없으면 전체목록 큐에 추가하고 뎁스 추가해서 다음 뎁스 확인해야지
        // 소스에서 뽑은 숫자기반으로 맵에서 리스트 추출,
        // 추출된 리스트내에 목적지 있으면 최단 경로에 depth추가하고 큐 초기화하고 탈출
        // 없으면 큐에 모든 도착지 넣어놓고 다음 큐 이동
        // 다음 큐에선 또 그 도착지 정보가 출발지인 애들 맵에서 뽑아서 도착지 있는지 확인
        // 만나는 애들마다 몇번째 뎁스인지 인덱스찾아가서 설정

        // 위 전략은 실패. 애초에 양방향 그래프로 앞에 있는 값을 키로 map을 만드는 것부터가 틀린 전제임.
        int depth = 1;
        while (!queueWrapper.isEmpty()) {
            if (depth == n) {
                queueWrapper.clear();
                break;
            }

            Integer poll = queueWrapper.poll();
            Set<Integer> nodes = map.get(poll);
            for (Integer node : nodes) {
                if (notDupleSources.contains(node)) {
                    if (sourceValues[node] != -2) {
                        continue;
                    }

                    sourceValues[node] = depth;
                }

                queueWrapper.add(node);
            }

            depth++;
        }

        for (int idx : sources) {
            if (idx == destination) {
                answerList.add(0);
                continue;
            }

            answerList.add(sourceValues[idx]);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int n = 5;
//        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
//        int[] sources = {1,3,5};
//        int destination = 5;
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2,3};
        int destination = 1;


        ReturnArmyPoint returnArmyPoint = new ReturnArmyPoint();
        int[] solution = returnArmyPoint.solution(n, roads, sources, destination);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
