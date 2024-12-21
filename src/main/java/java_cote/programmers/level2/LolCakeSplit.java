package java_cote.programmers.level2;


public class LolCakeSplit {
    public int solution(int[] topping) {
        int answer = 0;
        int [] left = new int[10001];
        int [] right = new int[10001];
        int leftTypes = 0;
        int rightTypes = 0;

        for (int i : topping) {
            right[i]++;
        }

        for (int i = 0; i < 10001; i++) {
            rightTypes += right[i] > 0 ? 1 : 0;
        }

        for (int i : topping) {
            right[i]--;
            if (right[i] == 0) {
                rightTypes--;
            }

            if (left[i] == 0) {
                leftTypes++;
            }
            left[i]++;

            if (leftTypes == rightTypes) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        LolCakeSplit lolCakeSplit = new LolCakeSplit();
        int solution = lolCakeSplit.solution(topping);
        System.out.println(solution);
    }
}
