package java_cote.programmers.level2;

public class PiRoDo {
    private int limit;
    private int answer = -1;

    public int solution(int k, int[][] dungeons) {
        this.limit = k;


        return answer;
    }

    public void recur(int presentPiRoDo, int[][] dungeons, int recurResult) {
        if (presentPiRoDo >= limit) {
            answer = Math.max(recurResult, answer);
            return;
        }


        for (int i = 0; i < dungeons.length; i++) {

        }


    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        PiRoDo piRoDo = new PiRoDo();
        int solution = piRoDo.solution(k, dungeons);
        System.out.println(solution);
    }
}
