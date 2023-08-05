package java_lab.inheritance.inheritance2;


import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;

public class SpecialOrder extends Order {
    private String specialReason;
    private int specialCost;

    public SpecialOrder(String shippingAddress, int distance, int productCount, int taxRate) {
        super(shippingAddress, distance, productCount, taxRate);
    }

    public int calculateSpecialDeliveryCost() {
        int deliveryCost = this.calculateDeliveryCost();
        return deliveryCost * specialCost;
    }
}
