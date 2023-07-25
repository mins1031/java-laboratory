package java_lab.Test;

import java.util.Arrays;
import java.util.List;

public class LoopObjectProcessor {
    public void processor(List<Integer> integers) {
        integers.stream().forEach(integer ->
                {
                    try {
                        LoopObject.occurExceptionWhenValueOverTen(integer);
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            throw e;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
    }
}
