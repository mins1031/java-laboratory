package java_cote.programmers.level1;

public class StrangeChar {
    public String solution(String s) {
        String[] splitString = s.split(" ",-1);
        StringBuilder tempResult = new StringBuilder();

        for (String ss : splitString) {
            char[] chars = ss.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int i1 = i % 2;
                if (i1 == 0) {
                    String str = String.valueOf(chars[i]);
                    tempResult.append(str.toUpperCase());
                } else {
                    String str = String.valueOf(chars[i]);
                    tempResult.append(str.toLowerCase());
                }
            }

            tempResult.append(" ");
        }

        tempResult.deleteCharAt(tempResult.length() -1);

        return tempResult.toString();
    }

    public static void main(String[] args) {
        StrangeChar strangeChar = new StrangeChar();
//        String s = "try hello world";
        String s = "tr he wo";
        String solution = strangeChar.solution(s);
        System.out.println(solution);
    }
}
