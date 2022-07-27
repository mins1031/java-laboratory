package maplab;

import callby.Student;
import programmers.MatrixPlus;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapLab1 {

    public void countDupliment() {
        String s = "aaaBcCdcd";
        String[] split = s.split("");

        Set<String> hashSet = new HashSet<>(Arrays.asList(split));
        Map<String, Integer> map = new HashMap<>();

        for (String s1 : split) {
            if (hashSet.contains(s1)) {
                if (!map.containsKey(s1)) {
                    map.put(s1, 1);
                    continue;
                }

                Integer integer = map.get(s1);
                map.put(s1, integer + 1);
            }
        }

        System.out.println(map);

    }


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

        new MapLab1().countDupliment();
        int b = 7;
        Student student = new Student();
//        System.out.println(Math.min(student.getAge(), b));

        int temp = 20000;
        System.out.println(temp * 0.3);
    }
}
