package java_lab.equals_hashcode.equals_problum;

import java.util.Objects;

public class BasicOrder {
    private String name;
    private int cost;

    public BasicOrder(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof BasicOrder)) return false;
        BasicOrder that = (BasicOrder) o;
        return cost == that.cost && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
