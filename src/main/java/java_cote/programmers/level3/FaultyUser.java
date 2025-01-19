package java_cote.programmers.level3;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FaultyUser {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        // 조합을 구하려면 2차원 배열에 중복되면 안되는 종류별로 인덱스에 list로 모아놓고 하나씩 재귀로 돌려가며 짜내는거임.
        // 중복되면 안되는 종류별로 한 인덱스의 배열로 몰아넣은 2차원배열 구성
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (bans.length == index) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String ban : bans[index]) {
            if (banned.contains(ban)) {
                continue;
            }

            banned.add(ban);
            count(index + 1, banned, bans, banSet);
            //중복 목록중 처음 조합값에 대해 모두 구했으니 다음 인덱스값에 대한 조합값 구하기 위해 다 조합한 중복값은 제거.
            // ex
            // 0 = [apple, ace]
            // 1 = [bear, bb]
            // 2 = [cap, cop]
            // banned -> [apple, bear, cap] 이상태에서 cap 구한후 다음스텝으로가면 재귀가 종료됨. 이후 아래 코드를 만나게 되는데 cap과 cop은 중복되지 않게 조합으라 구해야 하기에 cap 대신 cop을 넣어줘야하기에 remove
            banned.remove(ban);
        }
    }

    public static void main(String[] args) {
        String[] user_ids = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_ids = {"fr*d*", "abc1**"};

        FaultyUser faultyUser = new FaultyUser();
        int solution = faultyUser.solution(user_ids, banned_ids);

        System.out.println(solution);
    }
}
