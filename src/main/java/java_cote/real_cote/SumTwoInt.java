package java_cote.real_cote;

public class SumTwoInt {
    public long respondBig(int a, int b) {
        return Math.max(a, b);
    }

    public long respondSmall(int a, int b) {
        return Math.min(a, b);
    }

    public long solution(int a, int b) {
        long answer = 0;
        long start = respondSmall(a, b);
        long end = respondBig(a, b);

        for (long count = start; count < end + 1; count++) {
            answer += count;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new SumTwoInt().solution(3, 5));
    }
}
