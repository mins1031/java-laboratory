package java_lab.reference;

public class User {
    private String name;
    private String massage;

    public User(String name) {
        this.name = name;
    }

    public void receive(String message) {
        this.massage = message;
        System.out.println(message);
    }
}
