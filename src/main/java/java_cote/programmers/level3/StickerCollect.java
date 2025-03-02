package java_cote.programmers.level3;

public class StickerCollect {
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }

        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        boolean[] first = new boolean[sticker.length];
        boolean[] second = new boolean[sticker.length];

        int firstValue = 0;
        int secondValue = 0;

        // 첫번쨰
        for (int i = 0; i < sticker.length; i++) {
            if (first[i]) {
                continue;
            }

            if (i == sticker.length - 1) {
                firstValue += sticker[i];
                continue;
            }

            if (i == 0) {
                calculateSticker(first, i, i+1, sticker.length - 1);
                firstValue += sticker[i];
                continue;
            }

            calculateSticker(first, i, i+1, i - 1);
            firstValue += sticker[i];
        }

        // 두번쨰
        for (int i = 0; i < sticker.length; i++) {
            if (second[i]) {
                continue;
            }

            if (i == sticker.length - 1) {
                secondValue += sticker[i];
                continue;
            }

            if (i == 0) {
                continue;
            }

            if (i == 1) {
                calculateSticker(second, i, i+1, i - 1);
                secondValue += sticker[i];
                continue;
            }

            if (sticker[i] >= sticker[i+1]) {
                calculateSticker(second, i, i+1, i - 1);
                secondValue += sticker[i];
                continue;
            }

            calculateSticker(second, i+1, i, i + 2);
            secondValue += sticker[i+1];
        }

        return Math.max(firstValue, secondValue);
    }

//    public int solution(int sticker[]) {
//        int answer = 0;
//        int len = sticker.length;
//
//        if (len == 1) return sticker[0];
//
//        int [] dp = new int[len];
//
//        // 첫 번째 스티커를 뗐을때
//        dp[0] = sticker[0];
//        dp[1] = dp[0];
//        for (int i = 2; i < len - 1; i++) {
//            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
//        }
//        answer = dp[len - 2];
//
//        // 첫 번째 스티커를 안뗐을때
//        dp[0] = 0;
//        dp[1] = sticker[1];
//        for (int i = 2; i < len; i++) {
//            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
//        }
//        answer = Math.max(answer, dp[len - 1]);
//        return answer;
//    }

    private void calculateSticker(boolean[] stickerStatus, int selectedIdx, int exceptedIdxOne, int exceptedIdxTwo) {
        stickerStatus[selectedIdx] = true;
        stickerStatus[exceptedIdxOne] = true;
        stickerStatus[exceptedIdxTwo] = true;
    }

    public static void main(String[] args) {
//        int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
        int sticker[] = {1, 3, 2, 5, 4};
        StickerCollect stickerCollect = new StickerCollect();
        int solution = stickerCollect.solution(sticker);
        System.out.println(solution);
    }
}
