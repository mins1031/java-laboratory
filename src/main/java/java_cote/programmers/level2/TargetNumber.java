package java_cote.programmers.level2;

public class TargetNumber {
    private int result = 0;
    private int target;
    private int[] numbers;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        recurrence(1, numbers[0]);
        recurrence(1, -numbers[0]);
        return result;
    }

    private void recurrence(int depth, int totalCount) {
        if (depth == numbers.length) {
            if (totalCount == target) {
                result++;
            }

            return;
        }


        int num = numbers[depth];
        recurrence(depth + 1, totalCount + num);
        recurrence(depth + 1, totalCount - num);
    }


    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int solution1 = targetNumber.solution(numbers1, target1);
        System.out.println(solution1);
        System.out.println(solution1 == 5);

        TargetNumber targetNumber2 = new TargetNumber();
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        int solution2 = targetNumber2.solution(numbers2, target2);
        System.out.println(solution2);
        System.out.println(solution2 == 2);
    }
}
