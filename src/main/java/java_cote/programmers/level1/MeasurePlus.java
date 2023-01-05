package java_cote.programmers.level1;

public class MeasurePlus {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (calculateMeasureCount(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public int calculateMeasureCount(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                count++;
            } else if (num % i == 0) {
                count += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        System.out.println(new MeasurePlus().solution(left, right));
    }
}
