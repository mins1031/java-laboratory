package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankingSearch {
    private static final int LAST_INDEX = 4;

    public int[] solution(String[] infos, String[] queries) {
        List<Integer> results = new ArrayList<>();

        Arrays.sort(infos, (a, b) -> {
            String[] splitA = a.split(" ");
            String[] splitB = b.split(" ");
            // 마지막 숫자 값 비교
            int lastNumberA = Integer.parseInt(splitA[LAST_INDEX]);
            int lastNumberB = Integer.parseInt(splitB[LAST_INDEX]);
            return Integer.compare(lastNumberA, lastNumberB);
        });


        for (String query : queries) {
            String[] splitAndQuery = query.split("and ");
            String[] splitQuery = String.join("", splitAndQuery).split(" ");
            int lowestScoreIndex = findLowestScoreIndex(infos, Integer.parseInt(splitQuery[LAST_INDEX]));
            Integer e = countSupporterInCondition(lowestScoreIndex, infos, splitQuery);
            results.add(e);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private int findLowestScoreIndex(String[] infos, int splitQuery) {
        int start = 0;
        int end = infos.length;

        while (start != end) {
            int mid = (end + start) / 2;
            String midInfo = infos[mid];
            int midInfoScore = Integer.parseInt(midInfo.split(" ")[LAST_INDEX]);

            if (midInfoScore >= splitQuery) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private Integer countSupporterInCondition(int startIndex, String[] infos, String[] splitQuery) {
        String languageCon = splitQuery[0];
        String positionCon = splitQuery[1];
        String careerCon = splitQuery[2];
        String soulFoodCon = splitQuery[3];

        int count = 0;

        for (int i = startIndex; i < infos.length; i++) {
            String[] splitInfos = infos[i].split(" ");
            boolean isLanguageCon = languageCon.equals("-") || splitInfos[0].equals(languageCon);
            boolean isPositionCon = positionCon.equals("-") || splitInfos[1].equals(positionCon);
            boolean isCareerCon = careerCon.equals("-") || splitInfos[2].equals(careerCon);
            boolean isSoulFoodCon = soulFoodCon.equals("-") || splitInfos[3].equals(soulFoodCon);

            if (isLanguageCon && isPositionCon && isCareerCon && isSoulFoodCon) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        RankingSearch rankingSearch = new RankingSearch();
        String[] infos = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] queries = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] solution = rankingSearch.solution(infos, queries);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
