package java_cote.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GoToSchoolPath {
    private List<Integer> pathCountList = new ArrayList<>();
    private int[][] puddles;
    private int n;
    private int m;

    public int solution(int m, int n, int[][] puddles) {
        this.puddles = puddles;
        this.m = m - 1;
        this.n = n - 1;

        move(0, 0, 0);

        Integer min = Collections.min(pathCountList);

        return (int) pathCountList.stream().filter(count -> Objects.equals(count, min)).count() % 1000007000;
    }

    public void move(int x, int y, int count) {
        if (isPuddle(x, y)) {
            return;
        }

        if (x > n || y > m) {
            return;
        }

        if (x == n && y == m) {
            this.pathCountList.add(count);
            return;
        }

        int rightCount = count;
        int bottomCount = count;

        move(x + 1, y, ++rightCount);
        move(x, y + 1, ++bottomCount);
    }

    private boolean isPuddle(int x, int y) {
        for (int[] puddle : puddles) {
            if (puddle[0]-1 == x && puddle[1]-1 == y) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] puddle = {/*{2, 2}, {3,1}*/};
        GoToSchoolPath goToSchoolPath = new GoToSchoolPath();
        int solution = goToSchoolPath.solution(5, 3, puddle);

        System.out.println(solution);
    }
}
