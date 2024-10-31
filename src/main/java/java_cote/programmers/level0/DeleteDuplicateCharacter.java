package java_cote.programmers.level0;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicateCharacter {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        Set<Character> objects = new HashSet<>();
        for (char aChar : myString.toCharArray()) {
            if (objects.contains(aChar)) {
                continue;
            }

            objects.add(aChar);
            answer.append(aChar);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        DeleteDuplicateCharacter deleteDuplicateCharacter = new DeleteDuplicateCharacter();
        String result = deleteDuplicateCharacter.solution("people");
        System.out.println(result);
    }
}
