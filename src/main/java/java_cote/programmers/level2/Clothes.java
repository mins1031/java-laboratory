package java_cote.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clothes {
    private Set<String> hashing = new HashSet<>();

    public void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
//            System.out.println(arr, visited, n);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    public int solution(String[][] clothes) {
        int answer = 0;
//        boolean[] visited = new boolean[];


        return answer;
    }

    public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            System.out.println("arr : " + Arrays.toString(arr) + ", visited : " + Arrays.toString(visited) + ", n : " + n);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public void combination(String[][] arr, boolean[] visited, int start, int n, int r, List<String> selected) {
        if(r == 0) {
            System.out.println("arr : " + print(arr) + ", visited : " + Arrays.toString(visited) + ", n : " + n);

            return;
        }

        for(int i=start; i<n; i++) {
            if (!alreadySelected(selected, arr[i][1])) {
                visited[i] = true;
                selected.add(arr[i][1]);
            }

            combination(arr, visited, i + 1, n, r - 1, selected);
            visited[i] = false;
        }
    }

    public boolean alreadySelected(List<String> selected, String category) {
        for (String s : selected) {
            if (s.equals(category)) {
                return true;
            }
        }

        return false;
    }

    public String print(String[][] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String[] strings : arr) {
            stringBuilder.append(strings[0] + " " + strings[1]);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Clothes clothes1 = new Clothes();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        boolean[] visited = new boolean[3];
        List<String> selected = new ArrayList<>();
        clothes1.combination(clothes, visited, 0, 3, 1, selected);

//        int solution = clothes1.solution(clothes);
//        System.out.println(solution);

//        int[] arr = {1,2,3,4};
//        boolean[] visited = new boolean[4];
//        clothes1.combination(arr, visited, 0, 4, 2);
    }
}
