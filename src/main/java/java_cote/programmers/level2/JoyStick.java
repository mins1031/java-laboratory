package java_cote.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        boolean normalDirection = true;
        Map<String, Integer> alphaPoint = initAlphaPoint();
        String[] alphaArray = name.split("");
        if (isAllA(alphaArray)) {
            return answer;
        }

        if ("A".equals(alphaArray[1])) {
            normalDirection = false;
        }

        answer += alphaPoint.get(alphaArray[0]);

        if (normalDirection) {
            for (int i = 1; i < alphaArray.length; i++) {
                if (i == alphaArray.length - 1 && "A".equals(alphaArray[i])) {
                    break;
                }

                answer++;
                answer += alphaPoint.get(alphaArray[i]);
            }
        } else {
            for (int i = alphaArray.length - 1; i > 0; i--) {
                if (i == 1 && "A".equals(alphaArray[i])) {
                    break;
                }

                answer++;
                answer += alphaPoint.get(alphaArray[i]);
            }
        }

        return answer;
    }

    private Map<String, Integer> initAlphaPoint() {
        Map<String, Integer> alphaPoint = new HashMap<>();
        alphaPoint.put("A", 0);
        alphaPoint.put("B", 1);
        alphaPoint.put("C", 2);
        alphaPoint.put("D", 3);
        alphaPoint.put("E", 4);
        alphaPoint.put("F", 5);
        alphaPoint.put("G", 6);
        alphaPoint.put("H", 7);
        alphaPoint.put("I", 8);
        alphaPoint.put("J", 9);
        alphaPoint.put("K", 10);
        alphaPoint.put("L", 11);
        alphaPoint.put("M", 12);
        alphaPoint.put("N", 13);
        alphaPoint.put("O", 12);
        alphaPoint.put("P", 11);
        alphaPoint.put("Q", 10);
        alphaPoint.put("R", 9);
        alphaPoint.put("S", 8);
        alphaPoint.put("T", 7);
        alphaPoint.put("U", 6);
        alphaPoint.put("V", 5);
        alphaPoint.put("W", 4);
        alphaPoint.put("X", 3);
        alphaPoint.put("Y", 2);
        alphaPoint.put("Z", 1);

        return alphaPoint;
    }

    public boolean isAllA(String[] alphaArray) {
        for (String alpha : alphaArray) {
            if (!"A".equals(alpha)) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        JoyStick joyStick = new JoyStick();
//        String name = "JEROEN";
//        String name = "JAN";
//        String name = "BCAAS"; // 1 + 1, 2 + 1, 0 + 1, 0 + 1, 8  -> 15
//        String name = "AAA"; // 0
        String name = "AQA"; // 11
        int solution = joyStick.solution(name);
        System.out.println(solution);
    }
}
