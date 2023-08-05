package java_lab.clone;

import java.util.Objects;

public class Subject implements Cloneable{
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Subject clone() throws CloneNotSupportedException {
        Subject temp = null;
        try {
            temp = (Subject) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
