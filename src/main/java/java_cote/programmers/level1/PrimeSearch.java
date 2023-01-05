package java_cote.programmers.level1;

public class PrimeSearch {

    public int search(int n) {
        boolean[] prime = new boolean[n + 1];
        int answer = 0;

        prime[0] = prime[1] = true;

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = 2 * i; j <= n; j += i) {
                prime[j] = true;
            }
        }

        //소수 개수 구하기
        for (int i = 0; i < prime.length; i++) {
            if (!prime[i]) answer++;
        }

        return answer;
    }


}
