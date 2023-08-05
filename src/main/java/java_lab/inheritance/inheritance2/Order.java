package java_lab.inheritance.inheritance2;

public class Order {
    private String shippingAddress;
    private int distance;
    private int productCount;
    private int taxRate;

    public Order(String shippingAddress, int distance, int productCount, int taxRate) {
        this.shippingAddress = shippingAddress;
        this.distance = distance;
        this.productCount = productCount;
        this.taxRate = taxRate;
    }

    public int calculateDeliveryCost() {
        return distance * productCount;
    }
}
