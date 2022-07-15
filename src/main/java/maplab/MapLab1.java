package maplab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapLab1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.get("two"));
        System.out.println(map.get("four"));

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
