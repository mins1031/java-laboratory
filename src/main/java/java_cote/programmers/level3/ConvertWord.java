package java_cote.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertWord {
    public static class State {
        private final int index;
        private final String presentBegin;
        private final String prevBegin;

        public State(int index, String presentBegin, String prevBegin) {
            this.index = index;
            this.presentBegin = presentBegin;
            this.prevBegin = prevBegin;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (checkTargetNotInWords(target, words)) {
            return answer;
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, begin, ""));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.presentBegin.equals(target)) {
                answer = state.index;
                break;
            }

            String[] presentBeginCharPieces = splitWord(state.presentBegin);
            for (String word : words) {
                if (word.equals(state.presentBegin) || word.equals(state.prevBegin)) {
                    continue;
                }

                String[] wordCharPieces = splitWord(word);

                int matchCharCount = 0;
                for (int i = 0; i < presentBeginCharPieces.length; i++) {
                    if (!presentBeginCharPieces[i].equals(wordCharPieces[i])) {
                        continue;
                    }

                    matchCharCount++;
                }

                if (matchCharCount != begin.length() - 1) {
                    continue;
                }

                queue.add(new State(state.index + 1, word, state.presentBegin));
            }

        }

        return answer;
    }

    private boolean checkTargetNotInWords(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return false;
            }
        }

        return true;
    }

    public String[] splitWord(String word) {
        return word.split("");
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};

        ConvertWord convertWord = new ConvertWord();
        System.out.println(convertWord.solution(begin, target, words));
    }
}
