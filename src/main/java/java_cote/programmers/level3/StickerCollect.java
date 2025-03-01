package java_cote.programmers.level3;

public class StickerCollect {
    public int solution(int sticker[]) {
        int answer = 0;

        // 만약 첫번쨰 시도면 0, 1 중 더 큰거 선택해야함
        // 그래서 먼저 스티커 갯수만큼 상태 설정한 리스트가 필요
        // 기본적으로는 현재 인덱스는 0,1,2 중 하나임 0= 아직 선택안된 1 = 선택된 , 2 = 선택으로인해 제외된
        // 1이면 지나치고 2이면 다음, 다다음 인덱스의 값을 비교함
            // 만약 다음이 상태가 0이 아니면 continue
            // 만약 다다음만 상태가 0이 아니면 다음 선택하고 continue
        // 다음 인덱스 >= 다다음 인덱스 : 다음 인덱스 선택
        // 다음 인덱스 < 다다음 인덱스
            // 다다음 인덱스 vs 다다다음 인덱스 비교해야함
            // 만약 다다다음 인덱스의 상태가 0이 아니면 -> 다음인덱스 선탠
            // 만약 다다다음 인덱스의 상태가 0이 아니면 -> 다음인덱스 선탠
            // 다다음 인덱스 >= 다다다음 인덱스 : 다다음 인덱스 선택하고 인덱스 상태 설정하고 다음진행
            // 다다음 인덱스 < 다다다음 인덱스 : 다음 인덱스 선택하고 인덱스 상태 설정하고 다음진행

        // 기본 0 적용 되어 있음
        int stickerIdxLenth = sticker.length - 1;
        int [] stickerStatus = new int[sticker.length];
        int maxSelectCount = sticker.length / 2;
        int selectCount = 0;

        for (int i = 0; i < sticker.length; i++) {
            if (selectCount >= maxSelectCount) {
                break;
            }

            if (i == 0) {
                int zeroIdxValue = sticker[0];
                int firstIdxValue = sticker[1];
                if (zeroIdxValue >= firstIdxValue) {
                    answer += sticker[calculateSticker(stickerStatus, 0, 1, stickerIdxLenth)];
                    selectCount ++;
                    continue;
                }

                answer += sticker[calculateSticker(stickerStatus, 1, 0, 2)];
                selectCount ++;
                continue;
            }


            if (stickerStatus[i] == 1) {
                continue;
            }

            if (i == stickerIdxLenth) {
                if (stickerStatus[i] == 0) {
                    answer += sticker[i];
                    selectCount ++;
                }

                continue;
            }
            if (stickerStatus[i] == 2) {
                if (i == stickerIdxLenth - 1) {
                    answer += sticker[i+1];
                    selectCount ++;
                    continue;
                }

                int nextIdxValue = sticker[i+1];
                int nnextIdxValue = sticker[i+2];

                if (stickerStatus[i+1] != 0) {
                    continue;
                }

                if (stickerStatus[i+2] != 0) {
                    answer += sticker[calculateSticker(stickerStatus, i+1, i, i+2)];
                    selectCount ++;
                    continue;
                }

                if (nextIdxValue >= nnextIdxValue) {
                    answer += sticker[calculateSticker(stickerStatus, i+1, i, i+2)];
                    selectCount ++;
                    continue;
                }

                if (nextIdxValue < nnextIdxValue) {
                    if (i == stickerIdxLenth - 2) {
                        answer += nnextIdxValue;
                        selectCount ++;
                        continue;
                    }

                    if (stickerStatus[i+3] != 0) {
                        answer += nnextIdxValue;
                        selectCount ++;
                        continue;
                    }
                    int nnnextIdxValue = sticker[i+3];

                    if (nnextIdxValue >= nnnextIdxValue) {
                        answer += sticker[calculateSticker(stickerStatus, i+2, i+1, i+3)];
                        selectCount ++;
                        continue;
                    }

                    answer += sticker[calculateSticker(stickerStatus, i+1, i, i+2)];
                    selectCount ++;
                }
            }
        }

        return answer;
    }

    private int calculateSticker(int[] stickerStatus, int selectedIdx, int exceptedIdxOne, int exceptedIdxTwo) {
        stickerStatus[selectedIdx] = 1;
        stickerStatus[exceptedIdxOne] = 2;
        stickerStatus[exceptedIdxTwo] = 2;
        return selectedIdx;
    }

    public static void main(String[] args) {
        int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
        StickerCollect stickerCollect = new StickerCollect();
        int solution = stickerCollect.solution(sticker);
        System.out.println(solution);
    }
}
