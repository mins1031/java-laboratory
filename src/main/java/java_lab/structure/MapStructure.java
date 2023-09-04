package java_lab.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapStructure {

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("Google", "USA");
        map.put("Naver", "Korea");
        map.put("Meta", "USA");
        map.put("Facebook", "USA");
        map.put("Samsung", "USA");
        map.put("Kakao", "USA");
        map.put("네이버", "USA");
        map.put("naver", "USA");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
