package ArraysAndStrings;

public class MaximumSubarray {
    private int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int preSum = nums[0];
        int maxSum = preSum;

        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }
}
