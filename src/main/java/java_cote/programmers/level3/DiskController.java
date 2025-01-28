package java_cote.programmers.level3;


import java.util.Objects;
import java.util.PriorityQueue;

public class DiskController {
    private static class DiskJob {
        private final int seq;
        private final int reqTime;
        private final int processTime;

        public DiskJob(int seq, int reqTime, int processTime) {
            this.seq = seq;
            this.reqTime = reqTime;
            this.processTime = processTime;
        }

        public int calculateTotalJobTime(int completeTime) {
            return completeTime - this.reqTime;
        }

        @Override
        public String toString() {
            return "DiskJob{" +
                    "seq=" + seq +
                    ", reqTime=" + reqTime +
                    ", processTime=" + processTime +
                    '}';
        }
    }


    //1. 소요시간이 짧은것
    //2. 요청시각이 빠른것
    //3. 번호가 작은것
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<DiskJob> waitQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.processTime > o2.processTime) {
                return 1;
            } else if (o1.processTime < o2.processTime) {
                return -1;
            } else {
                if (o1.reqTime > o2.reqTime) {
                    return 1;
                } else if (o1.reqTime < o2.reqTime) {
                    return -1;
                } else {
                    if (o1.seq > o2.seq) {
                        return 1;
                    }
                    return -1;
                }
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            DiskJob diskJob = new DiskJob(
                    i,
                    jobs[i][0],
                    jobs[i][1]
            );

            waitQueue.add(diskJob);
        }

        DiskJob presentJob = null;
        int totalExecutionCount = 0;
        int executionTimePerJob = 0;
        // TODO 이거구현 다시 해야한다. 미리 큐에 다 넣어놓고 구현하는게 아니라 요청시간 별로도 체크해서 시간 구해야함. -> 아래 반례 보면 금방 판단 가능
        while (Objects.nonNull(presentJob) || !waitQueue.isEmpty()) {
            if (Objects.isNull(presentJob)) {
                presentJob = waitQueue.poll();
                continue;
            }

            if (presentJob.reqTime > totalExecutionCount) {
                totalExecutionCount = presentJob.reqTime;
                continue;
            }

            if (presentJob.processTime > executionTimePerJob) {
                executionTimePerJob++;
                totalExecutionCount++;
                continue;
            }

            answer += presentJob.calculateTotalJobTime(totalExecutionCount);
            executionTimePerJob = 0;
            presentJob = null;
        }

        return answer / jobs.length;
    }

    private int compareProcessTime(DiskJob o1, DiskJob o2) {
        if (o1.processTime > o2.processTime) {
            return 1;
        } else if (o1.processTime < o2.processTime) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int[][] jobs = {{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}}; // 11
//        int[][] jobs = {{0, 1}, {2, 2}, {2, 3}}; // 2
//        int[][] jobs = {{0, 3}, {4, 4}, {5, 3}, {7, 1}}; // 4


        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println(solution);
    }
}
