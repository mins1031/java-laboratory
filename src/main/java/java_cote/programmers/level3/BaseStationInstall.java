package java_cote.programmers.level3;

// stations 기반으로 풀어야할듯.
// 만약 4, 11 면 4 - 1 -1(3까지 범위이므로) = 2 에 대해 아래공식적용 후 다음 최종 범위 값으로 4 + w = 5 로 가지고 있음
// 11이면 11 - 1 -1 = 9 - 5(최종범위값) + 1 = 3 에 대해 아래공식적용
// 9이면 9 - 2 - 1 = 6 에 대해 아래공식적용 = 2
// 근데 최종범위값이 n 이 아닌데 station이 끝이다?
// 추가계산 -> n - (최종범위값) = 16 - 11 = 5에 대해 아래공식 적용 = 2 * 2 + 1 = 5 == 1
public class BaseStationInstall {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int beforeMaxRange = 0;
        for (int i = 0; i < stations.length; i++) {
            int stationMinRange = Math.max(stations[i] - w, 1);
            int betweenDepth = stationMinRange - beforeMaxRange - 1;
            answer += calculateNeedStationCount(w, betweenDepth);

            int stationMaxRange = Math.min(stations[i] + w, n);
            beforeMaxRange = stationMaxRange;

            boolean isLastLoop = i == stations.length - 1;
            boolean isExistStationsToBack = stationMaxRange != n;
            if (isLastLoop && isExistStationsToBack) {
                int lastStations = n - stationMaxRange;
                answer += calculateNeedStationCount(w, lastStations);
            }
        }

        return answer;
    }

    private int calculateNeedStationCount(int w, int betweenDepth) {
        if (betweenDepth < 0) {
            return 0;
        }

        int share = betweenDepth / (w * 2 + 1);
        int rest = (betweenDepth % (w * 2 + 1)) == 0 ? 0 : 1;

        return share + rest;
    }

    public static void main(String[] args) {
//        int n = 11;
//        int[] stations = {4,11};
//        int w = 1;
//        int n = 16;
//        int[] stations = {9};
//        int w = 2;
        int n = 200000000;
        int[] stations = {100000000};
        int w = 5;

        BaseStationInstall baseStationInstall = new BaseStationInstall();
        int solution = baseStationInstall.solution(n, stations, w);
        System.out.println(solution);
    }
}
