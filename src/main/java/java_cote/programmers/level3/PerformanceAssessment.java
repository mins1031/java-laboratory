package java_cote.programmers.level3;

public class PerformanceAssessment {

    //조건
    // 1. 특정 사원이 다른사원 보다 근무태도, 동료평가가 모두 낮은 경우가 있다면 그 사원은 인센 x -> 필터 조건 --> 이중포문 못돌림 ㅋㅋ
    // 2. 필터후 두 점수를 합해서 정렬해야함.
    // 3. 완호의 등수를 찾아야함 score[0].
    // 4. 완호인센 못받으면 -1 출력

    //제한
    // 1. score 는 1~100,000.

    //방법
    //1. 스코어 객체 List 처리
    //2. 스코어


    public int solution(int[][] scores) {
        int answer = 0;
        for (int[] score : scores) {

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};

        PerformanceAssessment performanceAssessment = new PerformanceAssessment();
        int solution = performanceAssessment.solution(scores);
        System.out.println(solution);
    }
}
