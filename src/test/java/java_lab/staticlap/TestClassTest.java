package java_lab.staticlap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

    @Test
    public void whenStaticUtilClassInheritance_thenOverridingFails() {
        SuperUtility superUtility = new SubUtility();
        Assertions.assertNotEquals("ECHO", superUtility.echoIt("ECHO")); // 자식 클래스로 인스턴스 생성했음으로 ECHO가 출력되야 하지만 static은 다형성이 되지 않아 부모 echoIt의 결과인 SUPER출력.
        Assertions.assertEquals("SUPER", superUtility.echoIt("ECHO"));

        SuperUtility superUtility2 = new SubUtility();
        Assertions.assertEquals("no staticECHO", superUtility2.echoItNotStatic("ECHO"));
        Assertions.assertNotEquals("SUPER", superUtility2.echoItNotStatic("ECHO"));
    }
}