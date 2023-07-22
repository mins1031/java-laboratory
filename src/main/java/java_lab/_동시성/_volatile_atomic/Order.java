package java_lab._동시성._volatile_atomic;

public class Order {
    private int id;
    private String receiverName;
    private volatile String arrivalDate;

    public void update(int id, String receiverName, String arrivalDate) {
        this.id = id;
        this.receiverName = receiverName;
        this.arrivalDate = arrivalDate;
    }
}
