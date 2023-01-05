package java_lab.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MashTest2 {

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Write your code here
        Set<Integer> sets = new HashSet<>(arr);
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer keyInteger : sets) {
            int frequency = Collections.frequency(arr, keyInteger);
            hashMap.put(keyInteger, frequency);
        }

        List<List<Integer>> result = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(3, 3, 1, 2, 1);
        List<Integer> integers = Arrays.asList(7, 12, 3);
        System.out.println(groupSort(integers));
    }
}
