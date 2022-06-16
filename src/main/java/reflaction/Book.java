package reflaction;

import javax.swing.plaf.SplitPaneUI;

public class Book {

    public static String A = "A";

    public String B = "B";

    public Book() {
    }

    public Book(String b) {
        B = b;
    }

    public void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
