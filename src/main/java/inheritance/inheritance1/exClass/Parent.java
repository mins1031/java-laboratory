package inheritance.inheritance1.exClass;

public abstract class Parent {
    private final String parent = "parent";

    public void isParent() {
        System.out.println("기존의 parent");
    }

    public String getParent() {
        return parent;
    }
}
