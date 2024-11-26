package java_cote.programmers.level3;

import java.util.Arrays;

public class Network {
    private int count = 1;
    private int n;
    public int solution(int n, int[][] computers) {
        this.n = n;
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) {
                    continue;
                }

                if (mem[i][j] != 0) {
                    continue;
                }

                loop(i, computers, mem, count);
                count++;
            }
        }

        return Arrays.stream(mem).flatMapToInt(Arrays::stream).summaryStatistics().getMax();
    }

    public void loop(int yline, int[][] computers, int[][] mem, int count) {
        // 여기서 파고 들어가야됨
        // 해당 라인 값 dfs 적용
        for (int i = 0; i < n; i++) {
            if (computers[yline][i] == 0) {
                continue;
            }

            if (mem[yline][i] != 0) {
                continue;
            }

            mem[yline][i] = count;
            loop(i, computers, mem, count);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] computers = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//                {1, 1, 0},
//                {1, 1, 1},
//                {0, 1, 1}
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1}

        };
        Network network = new Network();
        int solution = network.solution(n, computers);
        System.out.println(solution);
    }
}
