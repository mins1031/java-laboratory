package java_cote.programmers.level1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 얀에서는 매년 달리기 경주가 열립니다.
 * 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
 * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
 */


public class RunRace {
    public String[] solution(String[] players, String[] callings) {
        int playersCount = players.length;
        List<String> playerList = Arrays.asList(players);

        for (int i = 0; i < callings.length; i++) {
            int index = playerList.indexOf(callings[i]);
            Collections.swap(playerList, index, index - 1);
        }

        return playerList.toArray(new String[playersCount]);
    }
    /*
     * 1. players를 링크드 리스트로 변환
     * 2. 이후 callings를 for돌며 인덱스를 저장했다가. 삭제 -> 삽입하는 과정거침
     * 2-1. 이 과정에서 인덱스가 0 이라면 무시 -> 아마 이케이스는 안나오겠지만.. 처리필요.
     * 밑의 결과는 ["mumu", "kai", "mine", "soe", "poe"]
     * */

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] solution = new RunRace().solution(players, callings);
        System.out.println(Arrays.toString(solution));
    }
}
