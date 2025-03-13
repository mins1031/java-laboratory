package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TravelPath {
    private static class Path {
        public int pathNum;
        public String department;
        public String destination;

        public Path(int pathNum, String department, String destination) {
            this.pathNum = pathNum;
            this.department = department;
            this.destination = destination;
        }

        public int getPathNum() {
            return pathNum;
        }

        public String getDepartment() {
            return department;
        }

        public String getDestination() {
            return destination;
        }
    }

    // 출발지 기준 map을 만듬
    // 한번 사용한 티켓은 사용불가하기에 사용한 티켓 모아놓는 목록도 필요 -> 하나씩 번호부여하고 배열인덱스로 체크
    // 이 다음엔 뭐.. 노드 보고 처리만하면됨
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] mem = new boolean[tickets.length];
        Map<String, List<Path>> pathMap = new HashMap<>();
        int numCount = 1;
        for (String[] ticket : tickets) {
            List<Path> orDefault = pathMap.getOrDefault(ticket[0], new ArrayList<>());
            orDefault.add(new Path(numCount, ticket[0], ticket[1]));
            orDefault.sort(Comparator.comparing(Path::getDestination));

            pathMap.put(ticket[0], orDefault);
            numCount++;
        }

        Path icn = pathMap.get("ICN").get(0);

        Stack<Path> stack = new Stack<>();
        stack.add(icn);

        while (!stack.isEmpty()) {
            Path pop = stack.pop();
            if (mem[pop.pathNum]) {
                continue;
            }

            List<Path> paths = pathMap.get(pop.department);
            for (Path path : paths) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        TravelPath travelPath = new TravelPath();
        String[] solution = travelPath.solution(tickets);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
