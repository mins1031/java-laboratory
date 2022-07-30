package programmers.level1;

import java.util.HashMap;

public class NoCompletePlayer {
    public String solution(String[] participants, String[] completions) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            map.put(completion, map.getOrDefault(completion, 0) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }


        return answer;
//        Arrays.sort(participants);
//        Arrays.sort(completions);
//
//        for(int i=0; i<participants.length; i++) {
//            if(i == completions.length) {
//                answer = participants[i];
//                break;
//            }
//            if(!participants[i].equals(completions[i])) {
//                answer = participants[i];
//                break;
//            }
//        }

    }

    public static void main(String[] args) {
        String [] startPlayers1 = {"ap", "kiki", "eden"};
        String [] startPlayers2 = {"mislav", "stanko", "mislav", "ana"};
        String [] endPlayers1 = {"eden", "kiki"};
        String [] endPlayers2 = {"stanko", "ana", "mislav"};
        System.out.println(new NoCompletePlayer().solution(startPlayers1, endPlayers1));
//        new NoCompletePlayer().solution(startPlayers2, endPlayers2);
    }
}
