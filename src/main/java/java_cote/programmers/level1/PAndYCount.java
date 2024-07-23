package java_cote.programmers.level1;

public class PAndYCount {
    boolean solution(String s) {
        char p = 'p';
        int pCount = 0;
        char y = 'y';
        int yCount = 0;

        String sToLower = s.toLowerCase();

        char[] chars = sToLower.toCharArray();
        for (char aChar : chars) {
            if (aChar == p) {
                pCount++;
                continue;
            }

            if (aChar == y) {
                yCount++;
            }
        }

        return pCount == yCount;

//        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count(); ===> 지림사;
    }


    public static void main(String[] args) {
        PAndYCount pAndYCount = new PAndYCount();
        String s = "Pyy";

        boolean solution = pAndYCount.solution(s);
        System.out.println(solution);
    }
}
