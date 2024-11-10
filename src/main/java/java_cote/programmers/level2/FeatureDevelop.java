package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FeatureDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> progressQueue = new LinkedList<>();

        calculateEachProgressNeedDate(progresses, speeds, progressQueue);

        for (int i = 1; i <= 100; i++) {
            if (progressQueue.isEmpty()) {
                break;
            }

            int resultCount = deployment(progressQueue, i);

            if (resultCount == 0) {
                continue;
            }
            result.add(resultCount);
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    private int deployment(LinkedList<Integer> progressQueue, int i) {
        int resultCount = 0;
        while (true) {
            if (progressQueue.isEmpty()) {
                break;
            }

            int presentPercent = progressQueue.getFirst();
            if (presentPercent > i) {
                break;
            }

            progressQueue.pop();
            resultCount++;
        }

        return resultCount;
    }

    private void calculateEachProgressNeedDate(int[] progresses, int[] speeds, LinkedList<Integer> progressQueue) {
        for (int i = 0; i < progresses.length; i++) {
            int needProgressPercent = 100 - progresses[i];
            int needDate = needProgressPercent / speeds[i];
            int needRest = needProgressPercent % speeds[i];
            int resultDate = needDate + (needRest != 0 ? 1 : 0);
            progressQueue.add(resultDate);
        }
    }

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 30, 5};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        FeatureDevelop featureDevelop = new FeatureDevelop();
        int[] solution = featureDevelop.solution(progresses, speeds);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
