package StacksAndQueues;

import java.util.EmptyStackException;

public class StackMin {
    private static class StackNode {
        private int data;
        private StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    private StackNode top;
    private int min;

    public void push(int item) {
        StackNode t;
        if (isEmpty()) {
            min = item;
            t = new StackNode(item);
        }
        else if (item < min) {
            t = new StackNode(2 * item - min);
            min = item;
        }
        else
            t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        int returnMin ;
        if (item < min) {
            returnMin = min;
            min = 2 * min - item;
        }
        else
            returnMin = item;
        return returnMin;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int min() {
        if (isEmpty()) throw new EmptyStackException();
        return min;
    }

    public static void main(String[] args) {
        StackMin obj = new StackMin();
        System.out.println("Push: 11");
        obj.push(11);
        System.out.println("Push: 14");
        obj.push(14);
        System.out.println("Min :" + obj.min());
        System.out.println("Push: 6");
        obj.push(6);
        System.out.println("Push: 3");
        obj.push(3);
        System.out.println("Min :" + obj.min());
        System.out.println("Pop :" + obj.pop());
        System.out.println("Min :" + obj.min());
        System.out.println("Pop :" + obj.pop());
        System.out.println("Min :" + obj.min());
    }
}
