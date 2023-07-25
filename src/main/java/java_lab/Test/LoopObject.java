package java_lab.Test;

import java.util.List;

public class LoopObject {

    public static void occurExceptionWhenValueOverTen(Integer integer) throws Exception {
        if (integer > 10) {
            throw new Exception("10 넘어가서 에러 발생");
        }

        System.out.println(integer);
    }
}
