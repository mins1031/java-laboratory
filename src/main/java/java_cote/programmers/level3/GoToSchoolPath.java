package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoToSchoolPath {
    private List<Integer> pathCountList = new ArrayList<>();
    private int[][] puddles;
    private int[][] mem = new int[101][101];
    private int n;
    private int m;

    public int solution(int m, int n, int[][] puddles) {
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        this.puddles = puddles;
        this.m = m - 1;
        this.n = n - 1;

        return move(0, 0, 0) % 1000007000;

//        Integer min = pathCountList.isEmpty() ? 0 : Collections.min(pathCountList);
//
//        return (int) pathCountList.stream().filter(count -> Objects.equals(count, min)).count() % 1000007000;
    }

    public int move(int x, int y, int count) {
        if (mem[x][y] == -1) {
            return mem[x][y];
        }

        if (isPuddle(x, y)) {
            return 0;
        }

        if (x > n || y > m) {
            return 0;
        }

        if (x == n && y == m) {
            return 1;
        }

        int rightCount = count;
        int bottomCount = count;

        int rightResult = move(x + 1, y, ++rightCount);
        int leftResult = move(x, y + 1, ++bottomCount);
        mem[x][y] = rightResult + leftResult;

        return mem[x][y];
    }

    private boolean isPuddle(int x, int y) {
        for (int[] puddle : puddles) {
            if (puddle[0]-1 == y && puddle[1]-1 == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] puddle = {/*{2, 1}, */{2, 2}/*, {1, 3}*/};
        GoToSchoolPath goToSchoolPath = new GoToSchoolPath();
        int solution = goToSchoolPath.solution(4, 3, puddle);

        System.out.println(solution);
    }
}
