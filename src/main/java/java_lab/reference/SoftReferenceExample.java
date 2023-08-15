package java_lab.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        //strong의 null 선언으로 strong 참조는 생성된 레퍼런스에서 사라지고 soft내로 전달된 레퍼런스 참조만 살아있음으로 생성한 object 인스턴스엔 soft 참조만 연결되어있다.

        System.gc();
        Thread.sleep(2000);

        //메모리가 충분한 상황이라 soft 레퍼런스 객체는 굳이 수거 되지 않음.
        System.out.println(soft.get());
    }
}
