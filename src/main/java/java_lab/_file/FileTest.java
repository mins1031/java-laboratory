package java_lab._file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileTest {
    public static void main(String[] args) {
//        for (int i=0; i< 4000; i++) {
//            System.out.println("index : " + i);
//            new Thread(() -> {
//
//            })
//        }
    }

    public void fileTest() {
        File dirFile = new File("/Users/macbookair/Desktop/testfile");
        File[] fileList = dirFile.listFiles();
        Arrays.sort(fileList);
        List<String> retList = new ArrayList<String>();

        for (File file : fileList) {
            if (file.getName().contains(".rtf")) {   // upload_ 문자열이 있는지 체크
                retList.add(file.getName());    // 이름출력
                System.out.println(file.getName());
            }
        }
    }
}
