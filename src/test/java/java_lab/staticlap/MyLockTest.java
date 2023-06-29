package java_lab.staticlap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLockTest {
    public class MyLock {

        protected String takeLock(int locks) {
            return "Taken Specific Lock";
        }
    }

    public class SingletonLock extends MyLock {

        // private constructor and getInstance method

        @Override
        public String takeLock(int locks) {
            return "Taken Singleton Lock";
        }
    }

    @Test
    public void whenSingletonDerivesBaseClass_thenRuntimePolymorphism() {
        MyLock myLock = new MyLock();
        Assertions.assertEquals("Taken Specific Lock", myLock.takeLock(10));
        myLock = new SingletonLock();
        Assertions.assertEquals("Taken Singleton Lock", myLock.takeLock(10)); // 자식 클래스로 인스턴스 생성했음으로 Taken Singleton Lock가 출력. -> 다형성 o
    }
}
