package datastructure.stack;

public class Stack {

    private Object [] array;
    private int top = 0;
    private int size = 0;

    public Stack(int size) {
        this.top = -1;
        this.array = new Object[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }


}
