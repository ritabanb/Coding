package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int start, middle, end;
        for (start = 0; start < len; start++) {
            middle = start + 1;
            end = len - 1;

            while (middle < end) {
                if (nums[start] + nums[middle] + nums[end] == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[start]);
                    triplet.add(nums[middle]);
                    triplet.add(nums[end]);
                    if (!result.contains(triplet))
                        result.add(triplet);
                    middle++;
                    end--;
                }
                else if (nums[start] + nums[middle] + nums[end] < 0) {
                    middle++;
                }
                else {
                    end--;
                }
            }
        }
        return result;
    }
}
