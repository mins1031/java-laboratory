package java_lab.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        ReferenceQueue<Object> rq = new ReferenceQueue<Object>();
        WeakReference<Object> weak = new WeakReference<>(strong, rq);
        strong = null;
        //strong의 null 선언으로 strong 참조는 생성된 레퍼런스에서 사라지고 weak내로 전달된 레퍼런스 참조만 살아있음으로 생성한 object 인스턴스엔 weak 참조만 연결되어있다.
        System.out.println(rq.poll());

        System.gc();
        Thread.sleep(10000);

        //weak은 대부분 참조가 해제되면 gc시 수거됨.
        System.out.println(weak.get());
        System.out.println(weak);
        System.out.println(rq.poll());
    }
}
