package java_cote.programmers.level3;

import java.util.PriorityQueue;

public class NightWorkStatus {
    //TODO 생각보다 굉장히 쉽게 풀림... 풀이법을 블로그에서 참고하긴 했다.
    // 야근지수가 가장 작게 나오는 조건을 생각해내는것이 관건이었고 제곱하는 부분에 집중했어야 생각할 수 있었다.
    // 결국 전체 값을 최대한 비슷하게 만들어야 하기에 (= 큰수를 계속 줄여줘야 하기에) 우선순위큐를 사용해 가장 큰값에 대해 간단하고 지속적으로 지수를 줄여나갈수 있음.
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) {
            reverseQueue.add(work);
        }

        for (int i = 0; i < n; i++) {
            if (reverseQueue.isEmpty()) {
                break;
            }

            Integer poll = reverseQueue.poll();
            int status = poll - 1;
            if (status == 0) {
                continue;
            }
            reverseQueue.add(status);
        }

        for (Integer integer : reverseQueue) {
            answer += (long) integer * integer;
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] works = {4, 3, 3};
        int n = 4;

        NightWorkStatus nightWorkStatus = new NightWorkStatus();
        long solution = nightWorkStatus.solution(n, works);

        System.out.println(solution);

    }
}
