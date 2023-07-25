package java_lab._동시성._volatile_atomic;

public class SafeCounterWithLock {
    private int counter = 0;

    public synchronized void decrement() {
        counter--;
    }

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
