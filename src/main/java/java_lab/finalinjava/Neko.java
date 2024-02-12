package java_lab.finalinjava;

public class Neko {

    final static int STATIC_INT1 = 1;
    final static int STATIC_INT2;

    final int int1 = 1;
    final int int2;

    static {
        STATIC_INT2 = 2;

        // 상수는 한번 초기화하면 추가 선언x
//        STATIC_INT2 = 4;
    }

    public Neko() {
        this.int2 = 2;

        // 상수는 한번 초기화하면 추가 선언x
//        this.int2 = 4;

        final int localVal1 = 1;
        final int localVal2;

        localVal2 = 2;

        // 상수는 한번 초기화하면 추가 선언x
//        localVal1 = 2;
    }
}
