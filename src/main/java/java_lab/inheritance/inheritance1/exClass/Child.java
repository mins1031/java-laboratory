package java_lab.inheritance.inheritance1.exClass;

public class Child extends Parent{
    private final String child = "child";

    public void isChild() {
        System.out.println("child");
    }

    @Override
    public void isParent() {
        System.out.println("오버라이드한 isParent 메서드 이다");
    }
}
