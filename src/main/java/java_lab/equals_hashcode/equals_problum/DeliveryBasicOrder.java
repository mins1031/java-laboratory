package java_lab.equals_hashcode.equals_problum;

import java.util.Objects;

public class DeliveryBasicOrder extends BasicOrder {
    private final int receiverAge;

    public DeliveryBasicOrder(String name, int cost, int receiverAge) {
        super(name, cost);
        this.receiverAge = receiverAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryBasicOrder that = (DeliveryBasicOrder) o;
        return receiverAge == that.receiverAge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), receiverAge);
    }
}
