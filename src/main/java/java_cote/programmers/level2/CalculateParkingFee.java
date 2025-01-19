package java_cote.programmers.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalculateParkingFee {
    private static class VehicleRecord {
        private String time;
        private boolean isIn;

        public VehicleRecord(String time, boolean isIn) {
            this.time = time;
            this.isIn = isIn;
        }

        @Override
        public String toString() {
            return "VehicleRecord{" +
                    "time='" + time + '\'' +
                    ", isIn=" + isIn +
                    '}';
        }
    }

    public int[] solution(int[] fees, String[] records) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Map<String, List<VehicleRecord>> vehicleRecordMap = new TreeMap<>();
        for (String record : records) {
            String[] parkingRecord = record.split(" ");
            List<VehicleRecord> orDefault = vehicleRecordMap.getOrDefault(parkingRecord[1], new ArrayList<>());
            orDefault.add(new VehicleRecord(
                    parkingRecord[0],
                    "IN".equals(parkingRecord[2])
            ));
            vehicleRecordMap.put(parkingRecord[1], orDefault);
        }

        List<Integer> totalFeeList = new ArrayList<>();
        int basicMinuit = fees[0];
        int basicFee = fees[1];
        int perMinuit = fees[2];
        int perFee = fees[3];

        for (Map.Entry<String, List<VehicleRecord>> vehicleRecords : vehicleRecordMap.entrySet()) {
            String key = vehicleRecords.getKey();
            List<VehicleRecord> value = vehicleRecords.getValue();
            int totalTime = 0;
            int inTime = 0;
            for (int i = 0; i < value.size(); i++) {
                VehicleRecord peek = value.get(i);
                if (peek.isIn) {
                    int time = ((int) sdf.parse(peek.time).getTime());
                    boolean isLastRecord = (i + 1) == value.size();

                    if (isLastRecord) {
                        int calTime = (int) sdf.parse("23:59").getTime() - time;
                        totalTime += calTime / (1000 * 60);
                        break;
                    }

                    inTime = time;
                } else {
                    int outTime = ((int) sdf.parse(peek.time).getTime());

                    totalTime += (outTime - inTime) / (1000 * 60);
                }
            }

            if (totalTime <= basicMinuit) {
                totalFeeList.add(basicFee);
            } else {
                int dividePerMinuit = (totalTime - basicMinuit) / perMinuit;
                int dividePerMinuitRest = (totalTime - basicMinuit) % perMinuit >= 1 ? 1 : 0;
                long feeResult = basicFee + (long) (dividePerMinuit + dividePerMinuitRest) * perFee;
                totalFeeList.add((int) feeResult);
            }

        }

        return totalFeeList.stream().mapToInt(d -> d).toArray();
    }

    public static void main(String[] args) throws ParseException {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        CalculateParkingFee calculateParkingFee = new CalculateParkingFee();
        int[] solution = calculateParkingFee.solution(fees, records);
        Arrays.stream(solution).forEach(System.out::println);
    }
}
