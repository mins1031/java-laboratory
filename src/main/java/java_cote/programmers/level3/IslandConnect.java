package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class IslandConnect {
//    private static class ConnectInfo {
//        private final int start;
//        private final int end;
//        private final int cost;
//
//        public ConnectInfo(int start, int end, int cost) {
//            this.start = start;
//            this.end = end;
//            this.cost = cost;
//        }
//
//        public int getStart() {
//            return start;
//        }
//
//        public int getEnd() {
//            return end;
//        }
//
//        public int getCost() {
//            return cost;
//        }
//    }
//
//    public int solution(int n, int[][] costs) {
//        int answer = 0;
//        int[] parentEachNode = IntStream.range(0, n).toArray();
//        List<ConnectInfo> costSoredIslandInfo = getCostSoredIslandInfo(costs);
//        Set<Integer> connectIslands = new HashSet<>();
//        // 3 -> 1  [3] = 3 , [1] = 3  ->>>  1 -> 2  [2] == [1] = 3   ->>>>>   2 -> 3 x
////        int root = costSoredIslandInfo.get(0).getStart();
////        parentEachNode[root] = root;
//        for (ConnectInfo connectInfo : costSoredIslandInfo) {
//            if (parentEachNode[connectInfo.start] == parentEachNode[connectInfo.end]) {
//                continue;
//            }
//
//            connectIslands.add(connectInfo.start);
//            connectIslands.add(connectInfo.end);
//            answer += connectInfo.cost;
//            parentEachNode[connectInfo.end] = parentEachNode[connectInfo.start];
//
//            if (connectIslands.size() == n) {
//                break;
//            }
//        }
//
//        return answer;
//    }
//
//
//    private List<ConnectInfo> getCostSoredIslandInfo(int[][] costs) {
//        List<ConnectInfo> list = new ArrayList<>();
//        for (int[] cost : costs) {
//            list.add(new ConnectInfo(cost[0], cost[1], cost[2]));
//        }
//        list.sort(
//                Comparator.comparing(ConnectInfo::getCost)
//                        .thenComparing(ConnectInfo::getStart)
//        );
//
//        return list;
//    }

    public int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        return findParent(parent, parent[node]);
    }
    public void union(int[] parent, int node1, int node2) {
        int p1 = findParent(parent, node1);
        int p2 = findParent(parent, node2);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int []parent = new int[n];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
            Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < costs.length; i++) {
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) { // 사이클 판단
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
//        int n = 5;
//        int[][] costs = {{0,1,5}, {1,2,3}, {2,2,3}, {3,1,2}, {3,0,4}, {2,4,6}, {4,0,7}}; // 15 정답
//        int n = 5;
//        int[][] costs = {{0,1,1}, {2,3,1}, {3,4,2}, {1,2,2}, {0,4,100}}; // 4 정답
        int n = 4;
        int[][] costs = {{0,1,5}, {1,2,3}, {2,3,3}, {3,1,2}, {3,0,4}}; // 9 정답


        IslandConnect islandConnect = new IslandConnect();
        int solution = islandConnect.solution(n, costs);

        System.out.println(solution);
    }
}
