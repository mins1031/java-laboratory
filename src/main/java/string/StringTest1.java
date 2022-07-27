package string;

public class StringTest1 {

    public static void main(String[] args) {
        String format = String.format("%04d%02d", 3, 15);
        System.out.println(format);

        String s1 = "String";
        String s2 = "String";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
