package java_cote.programmers.level2;

import java.util.Arrays;

public class QuardIntegrate {
    private int[][] classArr;

    public int[] solution(int[][] arr) {
        if (arr.length == 1) {
            int resultValue = classArr[0][1];
            int[] result = new int[2];
            result[resultValue] = 1;
            return result;
        }

        classArr = arr;

        int length = arr.length;
        int n = length / 2;
        int[] quardCount1 = quardCount(0, 0, n);
        int[] quardCount2 = quardCount(0, n, n);
        int[] quardCount3 = quardCount(n, 0, n);
        int[] quardCount4 = quardCount(n, n, n);

        if (isAllZeroValue(quardCount1, quardCount2, quardCount3, quardCount4)
        ) {
            return new int[] {1,0};
        }

        if (isAllOneValue(quardCount1, quardCount2, quardCount3, quardCount4)
        ) {
            return new int[] {0,1};
        }

        return sumAllCellValue(quardCount1, quardCount2, quardCount3, quardCount4);
    }

    private int [] quardCount(int x, int y, int reqN) {
        if (reqN == 1) {
            int resultValue = classArr[x][y];
            int[] result = new int[2];
            result[resultValue] = 1;
            return result;
        }

        int realN = reqN / 2;
        int[] result1 = quardCount(x, y, realN);
        int[] result2 = quardCount(x, y + realN, realN);
        int[] result3 = quardCount(x + realN, y, realN);
        int[] result4 = quardCount(x + realN, y + realN, realN);

        if (isAllZeroValue(result1, result2, result3, result4)
        ) {
            return new int[] {1,0};
        }

        if (isAllOneValue(result1, result2, result3, result4)
        ) {
            return new int[] {0,1};
        }

        return sumAllCellValue(result1, result2, result3, result4);
    }

    private boolean isAllZeroValue(int[] result1, int[] result2, int[] result3, int[] result4) {
        return (result1[0] == 1 && result1[1] == 0)
                && (result2[0] == 1 && result2[1] == 0)
                && (result3[0] == 1 && result3[1] == 0)
                && (result4[0] == 1 && result4[1] == 0);
    }

    private boolean isAllOneValue(int[] result1, int[] result2, int[] result3, int[] result4) {
        return (result1[1] == 1 && result1[0] == 0)
                && (result2[1] == 1 && result2[0] == 0)
                && (result3[1] == 1 && result3[0] == 0)
                && (result4[1] == 1 && result4[0] == 0);
    }

    private int[] sumAllCellValue(int[] result1, int[] result2, int[] result3, int[] result4) {
        int zeroCount = result1[0] + result2[0] + result3[0] + result4[0];
        int oneCount = result1[1] + result2[1] + result3[1] + result4[1];

        return new int[] {zeroCount, oneCount};
    }


    // ======== MAIN ========
    public static void main(String[] args) {
        QuardIntegrate quardIntegrate = new QuardIntegrate();
//        int [][] pro1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
//        int [] anw1 = {4,9};
//        System.out.println(Arrays.toString(quardIntegrate.solution(pro1)));


        int [][] pro2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        int [] anw2 = {10,15};
        System.out.println(Arrays.toString(quardIntegrate.solution(pro2)));

        int [][] pro3 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
//        int [] anw3 = {10,15};
        System.out.println(Arrays.toString(quardIntegrate.solution(pro3)));
    }
}
