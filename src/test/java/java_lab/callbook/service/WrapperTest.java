package java_lab.callbook.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WrapperTest {

    @DisplayName("wrapper, primitive int 동등성 비교")
    @Test
    public void name() {
        int i1 = 5;
        int i5 = 5;
        Integer i2 = new Integer(5);

        Integer i3 = new Integer(5);
        Integer i4 = new Integer(5);

        Assertions.assertEquals(i1 == i2, true);
        Assertions.assertEquals(i2.equals(i1), true);
        Assertions.assertEquals(i3.equals(i4), true);
        Assertions.assertEquals(i3 == i4, false);
        Assertions.assertEquals(i1 == i5, true);
    }
}
