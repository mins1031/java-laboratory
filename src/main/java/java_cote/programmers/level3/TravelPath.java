package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class TravelPath {
    private static class Path {
        public String department;
        public String destination;

        public Path(String department, String destination) {
            this.department = department;
            this.destination = destination;
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int depth = tickets.length + 1;
        List<String> result = new ArrayList<>();

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
