package java_lab.overoad_override;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OverrideChildTeamTest {

    @Test
    public void name() {
        //given
        int a = 5;
        int b = 5;
        //when
        Assertions.assertTrue(a == b);

        //then
    }
}