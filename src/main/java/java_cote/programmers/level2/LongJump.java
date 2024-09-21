package java_cote.programmers.level2;

public class LongJump {
    public long solution(int n) {
        // DP 문제
        int[] dp = new int[n+1];
        if (n == 1 || n ==2) {
            return n;
        }

        dp[1] = 1;
        dp[2] = 2;

        int loopStart = 3;

        for (int i = loopStart; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        LongJump longJump = new LongJump();
        int n1 = 5;
        int n2 = 6;

        long solution1 = longJump.solution(n1);
        long solution2 = longJump.solution(n2);

        System.out.println(solution1);
        System.out.println(solution2);
    }
}
