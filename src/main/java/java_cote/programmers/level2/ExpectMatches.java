package java_cote.programmers.level2;

public class ExpectMatches {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int count = n;

        while (count > 0) {

            int tempAMock = a / 2;
            int tempARest = a % 2;
            int nextAPoint = tempAMock + tempARest;

            int tempBMock = b / 2;
            int tempBRest = b % 2;
            int nextBPoint = tempBMock + tempBRest;

            if (Math.abs(a - b) == 1 && nextAPoint == nextBPoint) {
                break;
            }

            a = nextAPoint;
            b = nextBPoint;
            answer += 1;
            count /= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        ExpectMatches expectMatches = new ExpectMatches();
        System.out.println(expectMatches.solution(n, a, b));
    }
}
