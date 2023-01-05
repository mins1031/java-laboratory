package java_cote.programmers.level1;

import java.util.Stack;

public class KraneDollSelectGame {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board[0].length;
        Stack<Integer> stack = new Stack();

        for (int move : moves) {
            for (int i = 0; i < size; i++) {
                if (board[i][move-1] != 0) {
                    if (!stack.empty() && stack.peek() == board[i][move-1]) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][move-1]);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};

        System.out.println(new KraneDollSelectGame().solution(board, moves));
    }
}
