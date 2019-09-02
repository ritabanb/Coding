package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class SortStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public SortStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int item) {
        stack1.add(item);
        while (!stack1.isEmpty()) {
            int data = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > data) {
                stack1.push(stack2.pop());
            }
            stack2.push(data);
        }
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        SortStack obj = new SortStack();
        System.out.println("Push: 5");
        obj.push(5);
        System.out.println("Push: 3");
        obj.push(3);
        System.out.println("Push: 4");
        obj.push(4);
        System.out.println("Pop: " + obj.pop());
        System.out.println("Peek: " + obj.peek());
        System.out.println("Push: 1");
        obj.push(1);
        System.out.println("Pop: " + obj.pop());
        System.out.println("Empty: " + obj.isEmpty());
        System.out.println("Pop: " + obj.pop());
        System.out.println("Pop: " + obj.pop());
        System.out.println("Empty: " + obj.isEmpty());
    }
}
