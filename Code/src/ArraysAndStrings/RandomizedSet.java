package ArraysAndStrings;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        List<Integer> vals = new ArrayList<Integer>(map.keySet());
        return vals.get(new Random().nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
