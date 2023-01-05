package java_lab.datastructure.stack;

import java.util.EmptyStackException;

public class IntStack {

    private int [] array;
    private int top = 0;
    private int size = 0;

    public IntStack(int size) {
        this.top = -1;
        this.array = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public void push(int item) {
        if (this.isFull()) {
            return;
        }

        array[++top] = item;
    }

    public int peek() {
        checkEmptyStack();

        return array[top];
    }

    public int pop() {
        checkEmptyStack();

        int topValue = array[top];
        array[top] = 0;
        return topValue;
    }

    public void clear() {
        this.top = -1;
        this.array = new int[this.size];
    }

    public void printStack() {
        checkEmptyStack();

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void checkEmptyStack() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
    }

}
