package java_cote.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Harshard {
    public boolean solution(int x) {
        int num = x;
        List<Integer> nums = new ArrayList<>();
        while (num != 0) {
            nums.add(num % 10);
            num = num / 10;
            System.out.println(num);
        }
        System.out.println(nums);

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        return (x % sum) == 0;
    }
    /*
     * 1. players를 링크드 리스트로 변환
     * 2. 이후 callings를 for돌며 인덱스를 저장했다가. 삭제 -> 삽입하는 과정거침
     * 2-1. 이 과정에서 인덱스가 0 이라면 무시 -> 아마 이케이스는 안나오겠지만.. 처리필요.
     * 밑의 결과는 ["mumu", "kai", "mine", "soe", "poe"]
     * */

    public static void main(String[] args) {
        int x = 18;
        boolean solution = new Harshard().solution(x);
        System.out.println(solution);
    }
}
