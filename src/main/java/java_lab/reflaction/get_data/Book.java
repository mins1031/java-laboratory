package java_lab.reflaction.get_data;

@MyAnnotation
public class Book {

    private static String B = "Book";
    private static final String C = "Book";

    private String a = "a";
    public String d = "d";
    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    public void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("G");
    }

    public int h() {
        return 100;
    }

    private String privateTest() {
        return "private";
    }

    protected String protectedTest() {
        return "protected";
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
