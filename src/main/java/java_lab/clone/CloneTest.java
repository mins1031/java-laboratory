package java_lab.clone;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Subject name1 = new Subject("name1");
        Subject clone = name1.clone();
    }
}
