package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStack<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T item) {
        stack1.add(item);
    }

    public T dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) throw new EmptyStackException();
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> obj = new QueueUsingStack<>();
        System.out.println("Enqueue: 1");
        obj.enqueue(1);
        System.out.println("Enqueue: 2");
        obj.enqueue(2);
        System.out.println("Dequeue: " + obj.dequeue());
        System.out.println("Enqueue: 3");
        obj.enqueue(3);
        System.out.println("Enqueue: 4");
        obj.enqueue(4);
        System.out.println("Dequeue: " + obj.dequeue());
        System.out.println("Dequeue: " + obj.dequeue());
        System.out.println("Dequeue: " + obj.dequeue());
    }
}
