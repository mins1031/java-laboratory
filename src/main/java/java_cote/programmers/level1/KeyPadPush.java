package java_cote.programmers.level1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyPadPush {
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        List<Integer> leftPads = List.of(1, 4, 7);
        List<Integer> rightPads = List.of(3, 6, 9);
        Map<Integer, Index> padIndexes = initPadIndexes();

        int presentLeft = 10;
        int presentRight = 11;

        for (int number : numbers) {
            if (leftPads.contains(number)) {
                result.append("L");
                presentLeft = number;
                continue;
            }
            if (rightPads.contains(number)) {
                result.append("R");
                presentRight = number;
                continue;
            }

            int leftDistance = calculateDistance(number, presentLeft, padIndexes);
            int rightDistance = calculateDistance(number, presentRight, padIndexes);

            if (leftDistance == rightDistance) {
                if (hand.equals("left")) {
                    result.append("L");
                    presentLeft = number;
                    continue;
                }

                if (hand.equals("right")) {
                    result.append("R");
                    presentRight = number;
                    continue;
                }
            }

            if (leftDistance < rightDistance) {
                result.append("L");
                presentLeft = number;
                continue;
            }

            if (leftDistance > rightDistance) {
                result.append("R");
                presentRight = number;
            }
        }

        return result.toString();
    }

    private Map<Integer, Index> initPadIndexes() {
        Map<Integer, Index> padIndexes = new HashMap<>();
        padIndexes.put(1, new Index(0, 0));
        padIndexes.put(2, new Index(0, 1));
        padIndexes.put(3, new Index(0, 2));
        padIndexes.put(4, new Index(1, 0));
        padIndexes.put(5, new Index(1, 1));
        padIndexes.put(6, new Index(1, 2));
        padIndexes.put(7, new Index(2, 0));
        padIndexes.put(8, new Index(2, 1));
        padIndexes.put(9, new Index(2, 2));
        padIndexes.put(0, new Index(3, 1));
        padIndexes.put(10, new Index(3, 0));
        padIndexes.put(11, new Index(3, 2));

        return padIndexes;
    }

    public int calculateDistance(int num, int present, Map<Integer, Index> padIndexes) {
        Index numIndex = padIndexes.get(num);
        Index presentIndex = padIndexes.get(present);

        return Math.abs(numIndex.getxIndex() - presentIndex.getxIndex())
                + Math.abs(numIndex.getyIndex() - presentIndex.getyIndex());
    }

    public class Index {
        private int xIndex;
        private int yIndex;

        public Index(int xIndex, int yIndex) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
        }

        public int getxIndex() {
            return xIndex;
        }

        public int getyIndex() {
            return yIndex;
        }
    }

    public static void main(String[] args) {
        KeyPadPush keyPadPush = new KeyPadPush();

        int[] nums = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = "LRLLLRLLRRL";

        System.out.println(keyPadPush.solution(nums, hand).equals(result));

        int[] nums2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        String result2 = "LRLLRRLLLRR";

        System.out.println(keyPadPush.solution(nums2, hand2).equals(result2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";
        String result3 = "LLRLLRLLRL";

        System.out.println(keyPadPush.solution(nums3, hand3).equals(result3));
    }
}
