package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KCountNum {
    private void editCommands(int[] array, int[][] commands, List<Integer> answerList) {
        for (int[] command : commands) {
            List<Integer> tmpArray = new ArrayList<>();
            for (int count = command[0]; count < command[1]+1; count++) {
                tmpArray.add(array[count-1]);
            }//위 과정을  int[] temp = Arrays.copyOfRange(array, commands[0]-1, commands[1]); 이렇게 적용가능
            Collections.sort(tmpArray);
            answerList.add(tmpArray.get(command[2]-1));
        }
    }

    public Integer[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        editCommands(array, commands, answerList);
        return answerList.toArray(new Integer[answerList.size()]);
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Integer[] solution = new KCountNum().solution(array, commands);
        System.out.println(Arrays.toString(solution));
    }
}
