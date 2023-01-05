package datastructure.stack;


import java.util.EmptyStackException;

public class LinkedStack <T> {

    private StackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T pop() {
        checkEmptyStack();

        T value = top.getValue();
        top = top.getNext();
        return value;
    }

    public void push(T value) {
        StackNode<T> tempNode = new StackNode<>(value);
        tempNode.setNext(top);
        top = tempNode;
    }

    public T peek() {
        checkEmptyStack();

        return top.getValue();
    }

    private void checkEmptyStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
