package java_lab.equals_hashcode;


import java.util.Objects;

public class DefinedEqualsAndHashcodeStudent {

    private String name;
    private int age;

    public DefinedEqualsAndHashcodeStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefinedEqualsAndHashcodeStudent that = (DefinedEqualsAndHashcodeStudent) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
