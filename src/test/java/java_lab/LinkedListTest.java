package java_lab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    @Test
    void 어레이리스트_링크드리스트_FIND_성능테스트() {
        String sample = "sample";
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int index = 1; index < 5000001; index++) {
            String addWord = sample + index;
            arrayList.add(addWord);
            linkedList.add(addWord);
        }

        List<String> requestWords = Arrays.asList(
                "sample10",
                "sample7241",
                "sample7147",
                "sample77727",
                "sample943418",
                "sample46850",
                "sample473380",
                "sample25849",
                "sample215922",
                "sample347485"
        );

        long arrayListStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            arrayList.contains(requestWord);
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListRemoveTime = arrayListEndTime - arrayListStartTime;

        long linkedListStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            linkedList.contains(requestWord);
        }
        long linkedListEndTime = System.nanoTime();
        long linkedListRemoveTime = linkedListEndTime - linkedListStartTime;

        System.out.println("arrayList contains find time = " + arrayListRemoveTime);
        System.out.println("linkedList contains find time = " + linkedListRemoveTime);

        long arrayListIndexOfStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            arrayList.indexOf(requestWord);
        }
        long arrayListIndexOfEndTime = System.nanoTime();
        long arrayListIndexOfTime = arrayListIndexOfEndTime - arrayListIndexOfStartTime;

        long linkedListIndexOfStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            linkedList.indexOf(requestWord);
        }
        long linkedListIndexOfEndTime = System.nanoTime();
        long linkedListIndexOfTime = linkedListIndexOfEndTime - linkedListIndexOfStartTime;

        System.out.println("arrayList indexOf find time = " + arrayListIndexOfTime);
        System.out.println("linkedList indexOf find time = " + linkedListIndexOfTime);
    }


    @Test
    void 어레이리스트_링크드리스트_ADD_성능테스트() {
        String sample = "sample";
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        long arrayListStartTime = System.nanoTime();
        for (int index = 1; index < 100001; index++) {
            String addWord = sample + index;
            arrayList.add(0, addWord);
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListRemoveTime = arrayListEndTime - arrayListStartTime;

        long linkedListStartTime = System.nanoTime();
        for (int index = 1; index < 100001; index++) {
            String addWord = sample + index;
            linkedList.addFirst(addWord);
        }
        long linkedListEndTime = System.nanoTime();
        long linkedListRemoveTime = linkedListEndTime - linkedListStartTime;
        System.out.println("arrayList add time = " + arrayListRemoveTime);
        System.out.println("linkedList add time = " + linkedListRemoveTime);
    }

    @Test
    void 어레이리스트_링크드리스트_DELETE_성능테스트() {
        String sample = "sample";
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int index = 1; index < 5000001; index++) {
            String addWord = sample + index;
            arrayList.add(addWord);
            linkedList.add(addWord);
        }

        List<String> requestWords = Arrays.asList(
                "sample10",
                "sample7241",
                "sample7147",
                "sample77727",
                "sample943418",
                "sample46850",
                "sample473380",
                "sample25849",
                "sample215922",
                "sample347485"
        );

        long arrayListStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            arrayList.remove(requestWord);
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListRemoveTime = arrayListEndTime - arrayListStartTime;

        long linkedListStartTime = System.nanoTime();
        for (String requestWord : requestWords) {
            linkedList.remove(requestWord);
        }
        long linkedListEndTime = System.nanoTime();
        long linkedListRemoveTime = linkedListEndTime - linkedListStartTime;

        System.out.println("arrayList remove time = " + arrayListRemoveTime);
        System.out.println("linkedList remove time = " + linkedListRemoveTime);
    }
}
