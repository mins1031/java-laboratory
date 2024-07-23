package java_cote.programmers.level1;

public class CeasurePassword {
    public String solution(String s, int n) {
        //1. char 배열로 만든다
        //2. 각 배열에 밀어야하는 수만큼 더해준다.
        //3. 단 더한값이 최대값을 넘어가게 되면 넘어간수 - 기존수 의 값으로 대체한다.
        //4. 계산이 끝나면 해당 char를 문자로 변경해 문자열 answer을 만든다.
        int bigA = 'A';
        int bigZ = 'Z';
        int smallA = 'a';
        int smallZ = 'z';
        StringBuilder stringBuilder = new StringBuilder();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                stringBuilder.append(" ");
                continue;
            }

            int tempChar = aChar;
            int tempResult = tempChar + n;

            if (Character.isUpperCase(aChar)) {
                if (tempResult > bigZ) {
                    char i = (char) (tempResult - bigZ + bigA - 1);
                    stringBuilder.append(i);
                } else {
                    char i = (char) tempResult;
                    stringBuilder.append(i);
                }
            } else {
                if (tempResult > smallZ) {
                    char i = (char) (tempResult - smallZ + smallA - 1);
                    stringBuilder.append(i);
                } else {
                    char i = (char) tempResult;
                    stringBuilder.append(i);
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CeasurePassword ceasurePassword = new CeasurePassword();

        String s = "Z";
        int n = 2;
        String solution = ceasurePassword.solution(s, n);
        System.out.println(solution);
    }
}
