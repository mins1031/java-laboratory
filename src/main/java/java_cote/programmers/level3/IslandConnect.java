package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class IslandConnect {
    private static class ConnectInfo {
        private final int start;
        private final int end;
        private final int cost;

        public ConnectInfo(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parentEachNode = new int[n];
        List<ConnectInfo> costSoredIslandInfo = getCostSoredIslandInfo(costs);
        Set<Integer> connectIslands = new HashSet<>();

        int root = costSoredIslandInfo.get(0).getStart();
        parentEachNode[root] = root;
        for (ConnectInfo connectInfo : costSoredIslandInfo) {
            if (parentEachNode[connectInfo.start] == parentEachNode[connectInfo.end]) {
                continue;
            }
            if (root == connectInfo.end) {
                parentEachNode[connectInfo.start] = connectInfo.end;
            }



            connectIslands.add(connectInfo.start);
            connectIslands.add(connectInfo.end);
            answer += connectInfo.cost;
            if (root != connectInfo.end) {
                parentEachNode[connectInfo.end] = connectInfo.start;
            } else {
                parentEachNode[connectInfo.start] = connectInfo.end;
            }

            if (connectIslands.size() == n) {
                break;
            }
        }

        return answer;
    }

    private boolean checkCircle(int[] parentEachNode, ConnectInfo connectInfo) {
        for (int i : parentEachNode) {
            if (i == connectInfo.start) {
                return true;
            }
        }

        return false;
    }

    private List<ConnectInfo> getCostSoredIslandInfo(int[][] costs) {
        List<ConnectInfo> list = new ArrayList<>();
        for (int[] cost : costs) {
            list.add(new ConnectInfo(cost[0], cost[1], cost[2]));
        }
        list.sort(
                Comparator.comparing(ConnectInfo::getCost)
                        .thenComparing(ConnectInfo::getStart)
        );

        return list;
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
//        int n = 5;
//        int[][] costs = {{0,1,5}, {1,2,3}, {2,2,3}, {3,1,2}, {3,0,4}, {2,4,6}, {4,0,7}}; // 15 정답
//        int n = 5;
//        int[][] costs = {{0,1,1}, {2,3,1}, {3,4,2}, {1,2,2}, {0,4,100}}; // 4 정답
        int n = 4;
        int[][] costs = {{0,1,5}, {1,2,3}, {2,3,3}, {3,1,2}, {3,0,4}}; // 4 정답


        IslandConnect islandConnect = new IslandConnect();
        int solution = islandConnect.solution(n, costs);

        System.out.println(solution);
    }
}
