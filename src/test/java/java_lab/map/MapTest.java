package java_lab.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @DisplayName("")
    @Test
    void name() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(hashMap);
    }

    @Test
    void 클래스로더_프린트() {
        String a = "d";
        Integer b = 3;
        System.out.println(a.getClass().getClassLoader());
        System.out.println(b.getClass().getClassLoader());
    }
}
