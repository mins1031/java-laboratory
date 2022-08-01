package programmers.level1;


public class MissingNum {
    public int solution(int[] numbers) {
        int answer = 0;
        int tempSum = 0;
        for (int i = 0; i < 10; i++) {
            tempSum += i;
        }

        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }

        return tempSum - answer;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] numbers2 = {5, 8, 4, 0, 6, 7, 9};
        MissingNum missingNum = new MissingNum();
        System.out.println(missingNum.solution(numbers1));
        System.out.println(missingNum.solution(numbers2));
    }
}
