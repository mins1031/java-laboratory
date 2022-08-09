package string;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public Map<String, Integer> countChar(String str) {
        String[] split = str.split("");
        String[] indexArray = new String[split.length];

        Map<String, Integer> map = new HashMap<>();

        for (String s : split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        CharCount charCount = new CharCount();
        String testStr = "aaccCfFFnNmmmmkkkkkkLll";
        Map<String, Integer> map = charCount.countChar(testStr);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
