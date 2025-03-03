package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class ReturnArmyPoint {
    public static class Node{
        private final int department;
        private final int arrivement;

        public Node(int department, int arrivement) {
            this.department = department;
            this.arrivement = arrivement;
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answerList = new ArrayList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int[] road : roads) {
            List<Node> value = map.getOrDefault(road[0], new ArrayList<>());
            value.add(new Node(road[0], road[1]));

            map.put(road[0], value);
        }

        for (int source : sources) {
            if (source == destination) {
                answerList.add(0);
                continue;
            }
            if (Objects.isNull(map.get(source))) {
                answerList.add(-1);
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(map.get(source).get(0).department);

            // 맵에서 출발지 정보로 조회해서 리스트 돌려보고 목적지 있으면 뎁스 적용해서 큐비우고 탈출하고 없으면 전체목록 큐에 추가하고 뎁스 추가해서 다음 뎁스 확인해야지
            // 소스에서 뽑은 숫자기반으로 맵에서 리스트 추출,
            // 추출된 리스트내에 목적지 있으면 최단 경로에 depth추가하고 큐 초기화하고 탈출
            // 없으면 큐에 모든 도착지 넣어놓고 다음 큐 이동
            // 다음 큐에선 또 그 도착지 정보가 출발지인 애들 맵에서 뽑아서 도착지 있는지 확인
            int depth = 1;
            int shortestPath = 0;
            boolean isExit = false;
            while (!queue.isEmpty()) {
                if (isExit) {
                    break;
                }

                if (depth == n) {
                    shortestPath = depth;
                    queue.clear();
                    break;
                }

                Integer poll = queue.poll();
                List<Node> nodes = map.get(poll);
                for (Node node : nodes) {
                    if (node.arrivement == destination || node.department == destination) {
                        shortestPath = depth;
                        queue.clear();
                        isExit = true;
                        break;
                    }

                    queue.add(node.arrivement);
                }

                depth++;
            }

            answerList.add(shortestPath);
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
