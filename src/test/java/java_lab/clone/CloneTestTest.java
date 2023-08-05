package java_lab.clone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloneTestTest {

    @DisplayName("")
    @Test
    public void name() throws CloneNotSupportedException {
        //given
        Subject name1 = new Subject("name1");
        Subject clone = name1.clone();

        //when && then
        Assertions.assertFalse(name1 == clone);
        Assertions.assertTrue(name1.equals(clone));
    }
}