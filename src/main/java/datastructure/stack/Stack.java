package datastructure.stack;

public class Stack<T> {

    private Object [] array;
    private int top = 0;

    public Stack(int top) {
        this.array = new Object[top];
    }


}
