package java_cote.real_cote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSouthundSixTear {
    private enum Day{
        SUN(3, "SUN"),
        MON(4, "MON"),
        TUE(5, "TUE"),
        WED(6, "WED"),
        THU(0, "THU"),
        FRI(1, "FRI"),
        SAT(2, "SAT"),
        ;

        private int restValueOfDay;
        private String desc;

        Day(int restValueOfDay, String desc) {
            this.restValueOfDay = restValueOfDay;
            this.desc = desc;
        }

        public int getRestValueOfDay() {
            return restValueOfDay;
        }

    }
    private Map<Integer, Integer> setDaysMap() {
        Map<Integer, Integer> tmpMonthMap = new HashMap<>();
        tmpMonthMap.put(1, 31);
        tmpMonthMap.put(2, 29);
        tmpMonthMap.put(3, 31);
        tmpMonthMap.put(4, 30);
        tmpMonthMap.put(5, 31);
        tmpMonthMap.put(6, 30);
        tmpMonthMap.put(7, 31);
        tmpMonthMap.put(8, 31);
        tmpMonthMap.put(9, 30);
        tmpMonthMap.put(10, 31);
        tmpMonthMap.put(11, 30);
        tmpMonthMap.put(12, 31);
        return tmpMonthMap;
    }

    private int sumTotalDaysCount(int month, Map<Integer, Integer> dayCountInMonth) {
        int tmpDaysCount = 0;
        for (Integer integer : dayCountInMonth.keySet()) {
            if (integer == month) {
                break;
            }
            tmpDaysCount += dayCountInMonth.get(integer);
        }
        return tmpDaysCount;
    }

    public String solution(int month, int monthOfDay) {
        Map<Integer, Integer> dayCountInMonth = setDaysMap();
        int totalDays = sumTotalDaysCount(month, dayCountInMonth);
        int restValue = (totalDays + monthOfDay) % 7;
        return String.valueOf(Arrays.stream(Day.values())
                .filter(day -> day.getRestValueOfDay() == restValue)
                .findFirst().get());
    }

    public static void main(String[] args) {
        int month = 5;
        int monthOfDay = 24;

        String solution = new TwoSouthundSixTear().solution(month, monthOfDay);
        System.out.println(solution);
    }
}
