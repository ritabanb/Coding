package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T> {
    List<Stack<T>> setOfStacks;
    int size;
    public SetOfStacks(int size) {
        setOfStacks = new ArrayList<Stack<T>>();
        this.size = size;
    }

    public void push(T item) {
        if (setOfStacks.isEmpty()) {
            Stack<T> stack = new Stack<T>();
            stack.add(item);
            setOfStacks.add(stack);
        }
        else {
            boolean added = false;
            for (Stack<T> stack : setOfStacks) {
                if (stack.size() <= size) {
                    stack.add(item);
                    added = true;
                }
            }
            if (!added) {
                Stack<T> stack = new Stack<T>();
                stack.add(item);
                setOfStacks.add(stack);
            }
        }
    }

    public T pop() {
        if (setOfStacks.isEmpty()) throw new EmptyStackException();
        for (int i = setOfStacks.size() - 1; i >= 0; i++) {
            return setOfStacks.get(i).pop();
        }
        return null;
    }

    public T popAt(int index) {
        if (setOfStacks.size() <= index) throw new StackOverflowError();
        return setOfStacks.get(index - 1).pop();
    }

    public static void main(String[] args) {
        SetOfStacks<Integer> obj = new SetOfStacks<>(3);
        System.out.println("Push: 1");
        obj.push(1);
        System.out.println("Push: 2");
        obj.push(2);
        System.out.println("Push: 3");
        obj.push(3);
        System.out.println("Push: 4");
        obj.push(4);
        System.out.println("Push: 5");
        obj.push(5);
        System.out.println("Pop: " + obj.pop());
        System.out.println("Push: 6");
        obj.push(6);
        System.out.println("Push: 7");
        obj.push(7);
        System.out.println("Push: 8");
        obj.push(8);
        System.out.println("Push: 9");
        obj.push(9);
        System.out.println("Push: 10");
        obj.push(10);
        System.out.println("PopAt: " + obj.popAt(2));
    }
}
