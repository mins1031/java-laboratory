package java_lab.inheritance.inheritance2;

public class Animal {
    private String myClass;

    public Animal(String myClass) {
        this.myClass = myClass;
    }

    void showMe() {
        System.out.println(myClass);
    }
}
