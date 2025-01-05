package java_cote.real_cote;

public class TrainCost {
    public int solution(int[] start, int[] dest, int[] limit) {
        if (start.length != dest.length) {
            return 0;
        }

        int maxStation = 0;
        for (int stationNum : start) {
            maxStation = Math.max(maxStation, stationNum);
        }

        for (int stationNum : dest) {
            maxStation = Math.max(maxStation, stationNum);
        }

        int maxLimit = limit[maxStation];
        int N = start.length;
        int boardingCost = 1;

        int totalCost = 0;
        for (int i = 0; i < N; i++) {
            int startStation = start[i];
            int destStation = dest[i];
            int moveCost = Math.abs(startStation - destStation) * 2;

            totalCost += boardingCost;
            totalCost += moveCost;
        }

        if (totalCost > maxLimit) {
            return maxLimit;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] start = {0, 1};
        int[] dest = {10, 0};
        int[] limit = {1, 1, 1, 1, 9, 1, 1, 4, 2, 7, 25};

        TrainCost trainCost = new TrainCost();
        int solution = trainCost.solution(start, dest, limit);
        System.out.println(solution);
    }
}

// 0 ~ 99 총 100개의 역을 지난건 100 * 2 + 1 = 201임
// 0 ~ 9 총 10개의 역을 지난건 10 * 2 + 1 = 21임