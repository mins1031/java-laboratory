package java_cote.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber2 {

    private static class Node {
        private int totalResult;
        private int depth;

        public Node(int totalResult, int depth) {
            this.totalResult = totalResult;
            this.depth = depth;
        }
    }

        //number를 순서 안바꾸고 모두 사용해 target을 만드는 방법의 수를 구하는게 문제임
        // 일단 모든 방법의 수를 알아야하기에 BFS가 맞음
        // 1. 뎁스는 number의 size, 레벨 2니 시간복잡도 생긱 x지만 메모이제이션 할만한 방법이 뭐가 있는지는 계속 고민해보자.
        // 2. 진입점0 부터 시작. -> 결국 첫값도 +/- 를 나눠서 계산해봐야하기 때문에 첫 인덱스 부터 바로 +/- 나눠서 처리가능
        // 3. Node 클래스 생성 -> 노드엔 totalResult : 지금까지 더한값 , depth : 진행뎁스(numbers의 idx)
        // 4. 큐에서 노드 빼서 원사이클 작업
            // 4-0. 만약 노드의 depth == numburs.size()
                // 탈출로직 :  node.totalResult == target ? result++ : return
            // 4-1. 큐에서 노드 pop
            // 4-2. 새로운 노드 2개 생성
            // 4-2. pop 노드의 totalResult 추출
            // 4-3. 새로운 노드 2개 생성
                // 4-3-1 하나는 totalResult + ((양수)numbers[node.depth+1])
                // 4-3-2 하나는 totalResult + ((음수)numbers[node.depth+1])
                // 4-3-3. 노드 depth ++;으로 각 노드 생성
            // 4-4. 생성된 노드들 큐에 add
    public int solution(int[] numbers, int target) {
        int result = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(numbers[0], 0));
        queue.add(new Node(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.depth == numbers.length-1) {
                if (node.totalResult == target) {
                    result++;
                }

                continue;
            }

            queue.add(
                    new Node(
                            node.totalResult + numbers[node.depth+1],
                            node.depth+1
                    )
            );
            queue.add(
                    new Node(
                            node.totalResult - numbers[node.depth+1],
                            node.depth+1
                    )
            );
        }

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
