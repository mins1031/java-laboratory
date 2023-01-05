package java_lab.datastructure.queue;

public class ArrayQueue {

    private int[] array;
    private int size = 0;
    private int pointer = 0;

    public ArrayQueue(int size) {
        this.size = size;
        this.array = new int[size];
        this.pointer = -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.array.length == this.size;
    }

    public int size(){
        return this.size;
    }

    public void push(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.array[++pointer] = item;
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }

        return this.array[0];
    }

//    public int pop() {
//
//    }
}
