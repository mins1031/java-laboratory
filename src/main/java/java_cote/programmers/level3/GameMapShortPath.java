package java_cote.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortPath {
    public static class State {
        private final int x;
        private final int y;
        private final int currentCount;
        private final int beforeX;
        private final int beforeY;

        public State(int x, int y, int currentCount, int beforeX, int beforeY) {
            this.x = x;
            this.y = y;
            this.currentCount = currentCount;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
        }

        public static State of(int plusCount, int moveX, int moveY, State before) {
            return new State(
                    moveX,
                    moveY,
                    plusCount,
                    before.x,
                    before.y
            );
        }
    }

    int width = 0;
    int height = 0;

    public int solution(int[][] maps) {
        int answer = 200;
        width = maps[0].length;
        height = maps.length;

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1, 0, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.x == height - 1 && state.y == width - 1) {
                answer = Math.min(state.currentCount, answer);
                break;
            }

            if (state.currentCount > answer) {
                continue;
            }

            if (!checkCanNotAdd(state.x, state.y + 1, state.beforeX, state.beforeY, maps))
                queue.add(new State(state.x, state.y + 1, state.currentCount + 1, state.x, state.y)); // 동
            if (!checkCanNotAdd(state.x, state.y - 1, state.beforeX, state.beforeY, maps))
                queue.add(new State(state.x, state.y - 1, state.currentCount + 1, state.x, state.y)); // 서
            if (!checkCanNotAdd(state.x + 1, state.y, state.beforeX, state.beforeY, maps))
                queue.add(new State(state.x + 1, state.y, state.currentCount + 1, state.x, state.y)); // 남
            if (!checkCanNotAdd(state.x - 1, state.y, state.beforeX, state.beforeY, maps))
                queue.add(new State(state.x - 1, state.y, state.currentCount + 1, state.x, state.y)); // 북
        }

        return answer == 200 ? -1 : answer;
    }

    private boolean checkCanNotAdd(int moveX, int moveY, int beforeX, int beforeY, int[][] maps) {
        if (
                moveX >= height
                || moveY >= width
                || moveX < 0
                || moveY < 0
        ) {
            return true;
        }

        boolean isBlockWay = maps[moveX][moveY] == 0;

        return isBlockWay || isBackDirection(moveX, moveY, beforeX, beforeY);
    }

    private boolean isBackDirection(int moveX, int moveY, int beforeX, int beforeY) {
        boolean isXSame = moveX == beforeX;
        boolean isYSame = moveY == beforeY;

        return isXSame && isYSame;
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        GameMapShortPath gameMapShortPath = new GameMapShortPath();
        int solution = gameMapShortPath.solution(maps);
        System.out.println(solution);
    }
}
