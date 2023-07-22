package java_lab._동시성._volatile_atomic;

public class NormalCounter {
    private int counter = 3000;

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
