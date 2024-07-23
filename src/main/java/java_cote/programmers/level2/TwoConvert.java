package java_cote.programmers.level2;

public class TwoConvert {
    public int[] solution(String s) {
        String stand = s;
        int convertCount = 0;
        int deleteZeroCount = 0;

        while (!stand.equals("1")) {
            //1. s의 모든 0을제거
            //2. 제거된 s의 길이를 이진수로 변환
            //3. s를 2의 결과로 할당
            //4. 반복
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = stand.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    deleteZeroCount++;
                    continue;
                }
                stringBuilder.append(aChar);
            }
            convertCount++;

            stand = Integer.toString(stringBuilder.toString().length(), 2);
        }

        int[] answer = {convertCount, deleteZeroCount};
        return answer;
    }


    public static void main(String[] args) {
        String s = "110010101001";
        TwoConvert twoConvert = new TwoConvert();
        int[] solution = twoConvert.solution(s);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
}
