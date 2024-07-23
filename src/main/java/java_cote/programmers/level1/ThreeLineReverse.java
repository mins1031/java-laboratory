package java_cote.programmers.level1;

public class ThreeLineReverse {
    public int solution(int n) {
        String convertedThreeRadix = Integer.toString(n, 3);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = convertedThreeRadix.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        String reverseThreeRadix = stringBuilder.toString();
        return Integer.parseInt(reverseThreeRadix, 3);
    }


    public static void main(String[] args) {
        int n = 45;
        ThreeLineReverse threeLineReverse = new ThreeLineReverse();
        int solution = threeLineReverse.solution(n);
        System.out.println(solution);
    }
}
