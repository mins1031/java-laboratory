package java_lab.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test2 {
    public class PrintOut {
        private int documentNum;
        private int documentRequestSecond;
        private int pageCount;

        public PrintOut(int documentNum, int documentRequestSecond, int pageCount) {
            this.documentNum = documentNum;
            this.documentRequestSecond = documentRequestSecond;
            this.pageCount = pageCount;
        }

        public int getDocumentNum() {
            return documentNum;
        }

        public int getDocumentRequestSecond() {
            return documentRequestSecond;
        }

        public int getPageCount() {
            return pageCount;
        }

        public boolean comparePageCount(int comparedCount) {
            return this.pageCount > comparedCount;
        }
    }

    public int[] solution(int[][] data) {
        int[] answer = new int[data.length];
        answer[0] = 1;
        int answerCount = 1;
        int dataCount = 1;
        Deque<PrintOut> deque = new ArrayDeque<>();
        int standTime = data[0][1] + data[0][2];

        while (true) {
            if (deque.isEmpty() && dataCount > data.length) {
//                answer[dataCount-1] = deque.poll().getDocumentNum();
                break;
            }

            PrintOut presentPrintOut = new PrintOut(data[dataCount][0], data[dataCount][1], data[dataCount][2]);
            if (!deque.isEmpty() && data[dataCount][1] > standTime) {
                PrintOut recentPrintOut = deque.poll();
                standTime += recentPrintOut.getPageCount();
                answer[answerCount] = recentPrintOut.getDocumentNum();
                dataCount++;
                continue;
            }
            if (deque.isEmpty()) {
                deque.addLast(presentPrintOut);
                dataCount++;
            } else {
                if (!presentPrintOut.comparePageCount(deque.getLast().getPageCount())) {
                    PrintOut last = deque.pollLast();
                    deque.addLast(presentPrintOut);
                    deque.addLast(last);
                    dataCount++;
                    continue;
                }
                deque.addLast(presentPrintOut);
                dataCount++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int [][] data = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 25}};
        int [][] data2 = {{1, 0, 3},{2, 1, 3},{3, 3, 2},{4, 9, 1},{5, 10, 2}};
        int [][] data3 = {{1, 2, 10},{2, 5, 8},{3, 6, 9},{4, 20, 6},{5, 25, 5}};

        int[] solution = new Test2().solution(data3);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
