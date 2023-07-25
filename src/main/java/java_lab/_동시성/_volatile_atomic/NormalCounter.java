package java_lab._동시성._volatile_atomic;

public class NormalCounter {
    private int counter = 0;

    public void decrement() {
        counter--;
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
