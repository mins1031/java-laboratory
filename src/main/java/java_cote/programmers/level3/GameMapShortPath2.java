package java_cote.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortPath2 {
    public static class State {
        private final int x;
        private final int y;
        private final int currentCount;

        public State(int x, int y, int currentCount) {
            this.x = x;
            this.y = y;
            this.currentCount = currentCount;
        }
    }

    int width = 0;
    int height = 0;
    int [][] directions = {
            {0, 1}, // 동
            {0, -1}, // 서
            {1, 0}, // 남
            {-1, 0} // 북
    };

    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        width = maps[0].length;
        height = maps.length;
        boolean[][] mem = new boolean[height][width];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.x == height - 1 && state.y == width - 1) {
                answer = Math.min(state.currentCount, answer);
                continue;
            }

            if (state.currentCount > answer) {
                continue;
            }

            if (mem[state.x][state.y]) {
                continue;
            }

            mem[state.x][state.y] = true;

            toDirection(maps, mem, directions[0], queue, state); // 동
            toDirection(maps, mem, directions[1], queue, state); // 서
            toDirection(maps, mem, directions[2], queue, state); // 남
            toDirection(maps, mem, directions[3], queue, state); // 북
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void toDirection(int[][] maps, boolean[][] mem, int[] direction, Queue<State> queue, State state) {
        if (!isCanMoveToDirection(state, direction, mem, maps)) {
            return;
        }

        State stateToMove = new State(
                state.x + direction[0],
                state.y + direction[1],
                state.currentCount + 1
        );
        queue.add(stateToMove);
    }

    public boolean isCanMoveToDirection(State state, int[] direction, boolean[][] mem, int[][] maps) {
        int targetX = state.x + direction[0];
        int targetY = state.y + direction[1];

        if (targetX < 0
            || targetX >= height
            || targetY < 0
            || targetY >= width
        ) {
            return false;
        }

        if (mem[targetX][targetY]) {
            return false;
        }

        if (maps[targetX][targetY] == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        GameMapShortPath2 gameMapShortPath = new GameMapShortPath2();
        int solution = gameMapShortPath.solution(maps);
        System.out.println(solution);
    }
}
