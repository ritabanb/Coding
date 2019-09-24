package Design;

import java.util.*;

public class MedianFinder {
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int len = list.size();
        if (len % 2 == 0)
            return (double)(list.get(len/2 - 1) + list.get(len/2)) / 2;
        else
            return (double)list.get(len/2);
    }

    //Leetcode
    private Queue<Long> small = new PriorityQueue(), large = new PriorityQueue();

    public void addNum_2(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian_2() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
}
