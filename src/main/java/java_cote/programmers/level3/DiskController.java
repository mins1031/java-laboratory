package java_cote.programmers.level3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    //job map int - list로 손보고 jobcount 도 필요
    //현시점 처리전 현시점과 동일한 시점에 시작되야할 job을 대기큐에 넣는 작업필요
    //이후 현시점 상태처리 프로세스
    //1. 동작하는 job이 없는경우
        //1-1. 대기큐에 job이 있으면?
            //1-1-1. 있으면 꺼내서 현 job에 설정
            //1-1-2. 전체시간, 수행시간, jobcount++
            //1-1-3. continue
        //1-2. 대기큐에 job이 없으면?
            //1-2-1. 전체시간 ++ 후 continue
    //2. 동작하는 job이 있는경우
        //2-1. 수행시간이 == job 소요시간  과 동일한경우
            //2-1-1. 현 job null 처리, 수행시간 초기화
            //2-1-2. answer에 현시간 - 요청시간 추가
            //2-1-3. continue
        //2-2. 수행시간이 < job 소요시간  보다 적은경우
            //2-2-1. 수행시간++, 전체시간++
            //2-2-2. continue
        //2-3. 만약 위 처리후 jobCount == jobs.length 인경우 break
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<DiskJob> waitQueue = new PriorityQueue<>(setJobSortConditions());
        Map<Integer, List<DiskJob>> jobsMap = initJobsMap(jobs);

        DiskJob presentJob = null;
        boolean isMiddleTime = false;
        int totalExecutionCount = 0;
        int executionTimePerJob = 0;
        int jobCount = 0;
        while (true) {
            addThisTimeJobToQueue(waitQueue, jobsMap, totalExecutionCount, isMiddleTime);

            if (Objects.isNull(presentJob)) {
                if (waitQueue.isEmpty()) {
                    totalExecutionCount++;
                    isMiddleTime = false;
                    continue;
                }

                presentJob = waitQueue.poll();
                totalExecutionCount++;
                executionTimePerJob++;
                jobCount++;
                isMiddleTime = false;
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
            isMiddleTime = true;

            if (jobCount == jobs.length) {
                break;
            }
        }


        return answer / jobs.length;
    }

    //1. 소요시간이 짧은것
    //2. 요청시각이 빠른것
    //3. 번호가 작은것
    private void addThisTimeJobToQueue(PriorityQueue<DiskJob> waitQueue, Map<Integer, List<DiskJob>> jobsMap, int totalExecutionCount, boolean isMiddleTime) {
        if (isMiddleTime) {
            return;
        }

        List<DiskJob> diskJobs = jobsMap.get(totalExecutionCount);
        if (Objects.nonNull(diskJobs)) {
            waitQueue.addAll(diskJobs);
        }
    }

    private Map<Integer, List<DiskJob>> initJobsMap(int[][] jobs) {
        Map<Integer, List<DiskJob>> jobsMap = new HashMap<>();
        int seq = 0;
        for (int[] job : jobs) {
            int reqTime = job[0];
            int processTime = job[1];
            List<DiskJob> diskJobs = jobsMap.getOrDefault(reqTime, new ArrayList<>());
            diskJobs.add(
                    new DiskJob(
                            seq,
                            reqTime,
                            processTime
                    )
            );
            jobsMap.put(reqTime, diskJobs);
            seq++;
        }

        return jobsMap;
    }
    private Comparator<DiskJob> setJobSortConditions() {
        return (o1, o2) -> {
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
        };
    }

    public static void main(String[] args) {
//        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
//        int[][] jobs = {{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}}; // 11
//        int[][] jobs = {{0, 1}, {2, 2}, {2, 3}}; // 2
        int[][] jobs = {{0, 3}, {4, 4}, {5, 3}, {7, 1}}; // 4


        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println(solution);
    }
}
