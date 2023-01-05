package java_cote.real_cote;

import java.util.Arrays;

public class MatrixPlus {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int row = 0; row < arr1[0].length; row++) {
            for (int col = 0; col < arr2[0].length; col++) {
                answer[row][col] = arr1[row][col] + arr2[row][col];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] str1 = new int[][]{{1, 2}, {2, 3}};
        int[][] str2 = new int[][]{{3, 4}, {5, 6}};

        int[][] str3 = new int[][]{{1}, {2}};
        int[][] str4 = new int[][]{{3}, {4}};

        int[][] tno = new int[1][2];
        for (int[] ints : tno) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] solution = new MatrixPlus().solution(str3, str4);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
