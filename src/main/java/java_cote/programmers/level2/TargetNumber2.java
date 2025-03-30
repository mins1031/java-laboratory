package java_cote.programmers.level2;

public class TargetNumber2 {

    public int solution(int[] numbers, int target) {
        //number를 순서 안바꾸고 모두 사용해 target을 만드는 방법의 수를 구하는게 문제임
        // 일단 모든 방법의 수를 알아야하기에 BFS가 맞음
        // 1. 뎁스는 number의 size, 레벨 2니 시간복잡도 생긱 x지만 메모이제이션 할만한 방법이 뭐가 있는지는 계속 고민해보자.
        // 2.


        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
//        int[] numbers = {4,1,2,1};
//        int target = 4;

        TargetNumber2 targetNumber2 = new TargetNumber2();
        int solution = targetNumber2.solution(numbers, target);
        System.out.println(solution);
    }
}
