package java_lab.reflaction.myjackson;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private double age;

    private List<String> stringList = new ArrayList<>();
    private List<Double> doubleList = new ArrayList<>();

    public User() {
    }

    public User(String name, double age, List<String> stringList, List<Double> doubleList) {
        this.name = name;
        this.age = age;
        this.stringList = stringList;
        this.doubleList = doubleList;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public List<Double> getDoubleList() {
        return doubleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stringList=" + stringList +
                ", doubleList=" + doubleList +
                '}';
    }
}
