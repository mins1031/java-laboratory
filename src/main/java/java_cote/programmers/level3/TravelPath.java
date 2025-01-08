package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class TravelPath {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
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
