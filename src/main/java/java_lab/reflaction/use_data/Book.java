package java_lab.reflaction.use_data;

import java_lab.reflaction.get_data.MyAnnotation;

@MyAnnotation
public class Book {

    private static String A = "A";
    private String B = "B";

    public Book() {
    }

    public Book(String b) {
        B = b;
    }

    private void c() {
        System.out.println("C");
    }

    public void d() {
        System.out.println("D");
    }

    public int sum(int left, int right, int test) {
        return left + right;
    }

    public int multipleIntegers() {
        int result = 0;
        for (int i = 1; i < 200000; i++) {
            result += i;
        }

        for (int i = 1; i < 300000; i++) {
            result += i;
        }

        for (int i = 1; i < 400000; i++) {
            result += i;
        }

        return result;
    }
}
