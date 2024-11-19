package java_cote.programmers.level3;

public class Network {
    public int solution(int n, int[][] computers) {
        int result = n;
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = 0;
            }
        }

        int count = 1;
        checkLink(0, computers, mem, count);

        return result;
    }

    private void checkLink(int i, int[][] computers, int[][] mem, int count) {
        for (int k = 0; k < i; k++) {
            if (computers[i][k] == 0) {
                continue;
            }

            if (mem[i][k] == 1) {
                return;
            }

            mem[i][k] = count;
            checkLink(k, computers, mem, count);
        }
    }

    public void loop() {
        // 여기서 파고 들어가야됨
        // 해당 라인 값 dfs 적용
        // 
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        Network network = new Network();
        int solution = network.solution(n, computers);
        System.out.println(solution);
    }
}
