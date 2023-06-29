package java_lab.staticlap;

public class TestClass {
//  결론은 안됨!
    public static final String name = "정적 필드를 외부에서 다른 값으로 바꿀수 있는지 실험";

    private static final String name2 = "name2";

    private static void testA() {
        System.out.println("");
//        name = "t";
    }

}
