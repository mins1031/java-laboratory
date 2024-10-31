package java_cote.programmers.level3;

import java.util.Arrays;

public class Triangle {
    private int[][] mem = new int[501][501];
    private int[][] triangle;
    private int height;

    public int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        this.height = triangle.length - 1;
        this.triangle = triangle;

        return findDownLayerValue(0, 0);
    }

    private int findDownLayerValue(int x, int y) {
        int presentValue = triangle[x][y];

        if (x == height) {
            return presentValue;
        }

        if (mem[x][y] != -1) {
            return mem[x][y];
        }

        int left = presentValue + findDownLayerValue(x + 1, y);
        int right = presentValue + findDownLayerValue(x + 1, y+1);

        int max = Math.max(left, right);
        mem[x][y] = max;

        return max;
    }

    public static void main(String[] args) {
        int [][] req = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int solution = new Triangle().solution(req);
        System.out.println(solution);
    }
}
