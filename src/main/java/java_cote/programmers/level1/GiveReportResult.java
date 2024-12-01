package java_cote.programmers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GiveReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> answer = new LinkedHashMap<>();
        Map<String, Integer> reportResult = new HashMap<>();
        Map<String, Set<String>> reportListEachUser = new HashMap<>();

        for (String id : id_list) {
            answer.put(id, 0);
            reportListEachUser.put(id, new HashSet<>());
        }

        // 신고 횟수 카운팅 및 id당 신고한 id 추가
        countReportAndAddReportedId(report, reportResult, reportListEachUser);

        for (Map.Entry<String, Integer> reportResultEntry : reportResult.entrySet()) {

            String reportedId = reportResultEntry.getKey();
            Integer reportedCount = reportResultEntry.getValue();
            if (reportedCount < k) {
                continue;
            }

            for (Map.Entry<String, Set<String>> reportListEachId : reportListEachUser.entrySet()) {
                Set<String> reportList = reportListEachId.getValue();
                if (!reportList.contains(reportedId)) {
                    continue;
                }
                String reportId = reportListEachId.getKey();
                Integer sendMailCount = answer.get(reportId);
                answer.put(reportId, sendMailCount + 1);
            }
        }

        return convertAnswerToArray(id_list, answer);
    }

    private void countReportAndAddReportedId(String[] report, Map<String, Integer> reportResult, Map<String, Set<String>> reportListEachUser) {
        for (String eachReport : report) {
            String[] splitReport = eachReport.split(" ");
            int plusReportCount = reportResult.getOrDefault(splitReport[1], 0) + 1;

            if (reportListEachUser.get(splitReport[0]).contains(splitReport[1])) {
                continue;
            }

            reportResult.put(splitReport[1], plusReportCount);
            reportListEachUser.get(splitReport[0]).add(splitReport[1]);
        }
    }

    private int[] convertAnswerToArray(String[] id_list, Map<String, Integer> answer) {
        int [] result = new int[id_list.length];
        int cnt = 0;
        for (Integer value : answer.values()) {
            result[cnt] = value;
            cnt++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
//        String[] idList = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;


        GiveReportResult giveReportResult = new GiveReportResult();
        int[] solution = giveReportResult.solution(idList, report, k);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
