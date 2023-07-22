package java_lab._동시성._volatile_atomic;

public class SafeCounterWithLock {
    private int counter = 3000;

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}
