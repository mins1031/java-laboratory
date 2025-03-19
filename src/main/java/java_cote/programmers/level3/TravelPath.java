package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        List<String> answer = new ArrayList<>();
        boolean[] mem = new boolean[tickets.length+1];
        Map<String, List<Path>> pathMap = new HashMap<>();
        int numCount = 0;
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
        answer.add("ICN");

        while (!stack.isEmpty()) {
            Path pop = stack.pop();
            if (mem[pop.pathNum]) {
                continue;
            }
            mem[pop.pathNum] = true;

            Path newAddPath = null;
            List<Path> paths = pathMap.get(pop.getDestination());
            if (Objects.isNull(paths)) {
                answer.add(pop.getDestination());
                break;
            }

            for (Path path : paths) {
                if (mem[path.getPathNum()]) {
                    continue;
                }

                newAddPath = path;
                break;
            }

            if (Objects.isNull(newAddPath)) {
                answer.add(pop.getDestination());
                break;
            }

            answer.add(pop.getDestination());
            stack.add(newAddPath);
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        TravelPath travelPath = new TravelPath();
        String[] solution = travelPath.solution(tickets);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
