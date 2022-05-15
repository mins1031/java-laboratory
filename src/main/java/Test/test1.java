package Test;

public class test1 {
    private boolean recursionState = true;

    private long checkEqualProtionAndRest(long answer, int recursionStartPoint, int portion, int rest) {
        if(portion == rest) {
            answer += recursionStartPoint;
        }
        return answer;
    }

    private void checkPortionOverInput(int inputToInt, int portion) {
        if (portion == inputToInt) {
            recursionState = false;
        }
    }

    private long calculateInput(long n) {
        int count = 1;
        int tmpSum = 0;
        while (true) {
            if (n == count) {
                break;
            }
            tmpSum += (n * count) + count;
            count++;
        }
        return tmpSum;
    }

    public long solution(long n) {
        long answer = 0;
        int inputToInt = (int) n;
//        int recursionStartPoint = inputToInt + 1;
//        while (recursionState) {
//            if (inputToInt == 0 || inputToInt == 1) {
//                break;
//            }
//
//            int portion = recursionStartPoint / inputToInt;
//            int rest = recursionStartPoint % inputToInt;
//
//            checkPortionOverInput(inputToInt, portion);
//            answer = checkEqualProtionAndRest(answer, recursionStartPoint, portion, rest);
//
//            recursionStartPoint += 1;
//        }
        answer = (long) calculateInput(inputToInt);

        return answer;
    }

    public static void main(String[] args) {
        long n = 3;
        long n2 = 2;

        long solution = new test1().solution(4);
        System.out.println(solution);
    }
}
