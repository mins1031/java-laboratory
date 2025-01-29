package java_cote.programmers.level3;


import java.util.Comparator;
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
        PriorityQueue<DiskJob> waitQueue = new PriorityQueue<>(setJobSortConditions());
        //job map int - list로 손보고 jobcount 도 필요
        //현시점 처리전 현시점과 동일한 시점에 시작되야할 job을 대기큐에 넣는 작업필요
        //이후 현시점 상태처리 프로세스
            //1. 동작하는 job이 없는경우
                //1-1. 대기큐에 job이 있으면?
                    //1-1-1. 있으면 꺼내서 현 job에 설정
                    //1-1-2. 현 시간값, 수행시간, jobcount++
                    //1-1-3. continue
                //1-2. 대기큐에 job이 없으면?
                    //1-2-1 현 시간값 ++ 후 continue
            //2. 동작하는 job이 있는경우
                //2-1.



        DiskJob presentJob = null;
        int totalExecutionCount = 0;
        int executionTimePerJob = 0;
        int jobCount = 0;

        // 현재 동작중인 job이 있고 해당시점에 인입되는 job이 있으면 대기큐에 insert
        // 현재 동작중인 job이 없고 해당시점에 인입되는 job이 있으면 대기큐로 무조건 insert 한다음 카운트 안늘리고 바로 대기큐에서 뽑으면 됨.
        while (true) {
            if (Objects.isNull(presentJob)) {
                // 현재 동작중인 job은 없지만
                if (jobs[jobCount][0] == totalExecutionCount) {
                    waitQueue.add(
                            new DiskJob(
                                    jobCount,
                                    jobs[jobCount][0],
                                    jobs[jobCount][1]
                            )
                    );

                    continue;
                }

//                presentJob = new DiskJob(
//                        jobCount,
//                        jobs[jobCount][0],
//                        jobs[jobCount][1]
//                );
//                jobCount++;
//                totalExecutionCount++;
//                executionTimePerJob++;
                continue;
            }

            if (Objects.nonNull(presentJob)) {
                if (jobs[jobCount][0] == totalExecutionCount) {
                    waitQueue.add(
                            new DiskJob(
                                    jobCount,
                                    jobs[jobCount][0],
                                    jobs[jobCount][1]
                            )
                    );

                    continue;
                }
            }

            if (jobCount == jobs.length) {
                break;
            }
        }


        return answer / jobs.length;
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

    private void initQueue(int[][] jobs, PriorityQueue<DiskJob> waitQueue) {
        waitQueue.add(
                new DiskJob(
                        0,
                        jobs[0][0],
                        jobs[0][1]
                )
        );

//        for (int i = 0; i < jobs.length; i++) {
//            DiskJob diskJob = new DiskJob(
//                    i,
//                    jobs[i][0],
//                    jobs[i][1]
//            );
//
//            waitQueue.add(diskJob);
//        }
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
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
//        int[][] jobs = {{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}}; // 11
//        int[][] jobs = {{0, 1}, {2, 2}, {2, 3}}; // 2
//        int[][] jobs = {{0, 3}, {4, 4}, {5, 3}, {7, 1}}; // 4


        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println(solution);
    }
}
