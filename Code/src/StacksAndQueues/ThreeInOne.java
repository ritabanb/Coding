package StacksAndQueues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ThreeInOne {
    int arr[];
    int top[];
    int next[];
    int n;
    int free;

    public ThreeInOne(int n) {
        this.n = n;
        arr = new int[n];
        top = new int[3];
        next = new int[n];

        Arrays.fill(top, -1);
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        free = 0;
    }

    public boolean isFull() {
        return free == -1;
    }

    public boolean isEmpty(int index) {
        return top[index] == -1;
    }

    public void push(int item, int index) {
        if (isFull()) throw new StackOverflowError();
        free = index;
        int i = free;
        free = next[i];
        next[i] = top[index];
        top[index] = i;
        arr[i] = item;
    }

    public int pop(int index) {
        if (isEmpty(index)) throw new EmptyStackException();
        int i = top[index];
        top[index] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }
}
