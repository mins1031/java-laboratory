package callby;

public class CallByTest1 {

    public void test(String name, Integer integer, int i) {
        System.out.println(name);
        System.out.println(integer);
        System.out.println(i);
    }

    public void test2(Student student) {
        System.out.println(student);
    }

    public static void main(String[] args) {
        CallByTest1 callByTest = new CallByTest1();

        String s1 = "문자열";
        Integer integer = Integer.valueOf(2);
        int i = 1;
        System.out.println(s1);
        System.out.println(integer);
        System.out.println(i);
        callByTest.test(s1, integer, i);

        System.out.println("객체비교");

        Student a = new Student("a", 10);
        System.out.println(a);
        callByTest.test2(a);

    }
}
