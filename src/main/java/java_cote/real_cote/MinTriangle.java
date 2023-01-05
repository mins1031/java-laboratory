package java_cote.real_cote;

public class MinTriangle {
    private int extractMaxSize(int[][] sizes) {
        int realMaxSize = 0;
        for (int[] size : sizes) {
            int tmpMaxSize = Math.max(size[0], size[1]);
            if (tmpMaxSize > realMaxSize) {
                realMaxSize = tmpMaxSize;
            }
        }
        return realMaxSize;
    }

    private int extractMinSize(int[][] sizes) {
        int realMinSize = 0;
        for (int[] size : sizes) {
            int tmpMinSize = Math.min(size[0], size[1]);
            if (tmpMinSize > realMinSize) {
                realMinSize = tmpMinSize;
            }
        }
        return realMinSize;
    }

    public int solution(int[][] sizes) {
        int max = extractMaxSize(sizes);
        int min = extractMinSize(sizes);
        System.out.println(max);
        System.out.println(min);
        return min * max;
    }

    public static void main(String[] args) {
        int [][] sizes = {{60,50}, {30,70}, {60,30}, {80,40}};
        int solution = new MinTriangle().solution(sizes);
        System.out.println(solution);
    }
}
