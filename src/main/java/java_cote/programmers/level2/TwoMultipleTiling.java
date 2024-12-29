package java_cote.programmers.level2;

public class TwoMultipleTiling {
    public int solution(int n) {
        int[] mem = new int[n];
        mem[0] = 1 % 1000000007;
        mem[1] = 2 % 1000000007;
        for (int i = 2; i < n; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 1000000007;
        }

        return mem[n - 1] % 1000000007;
    }

    public static void main(String[] args) {
        int n = 52;
        TwoMultipleTiling twoMultipleTiling = new TwoMultipleTiling();
        int solution = twoMultipleTiling.solution(n);
        System.out.println(solution);
    }
}
