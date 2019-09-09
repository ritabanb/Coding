package ArraysAndStrings;

import java.util.HashMap;

public class TwoSum {
    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numberIndex = new HashMap<>();
        int diff;

        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (numberIndex.containsKey(diff)){
                return new int[]{numberIndex.get(diff), i};
            }
            numberIndex.put(nums[i], i);
        }
        return null;
    }
}
