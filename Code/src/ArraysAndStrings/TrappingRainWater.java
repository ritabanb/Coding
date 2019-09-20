package ArraysAndStrings;

public class TrappingRainWater {
    public int trap(int[] height) {
        int trapWater = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    trapWater += (leftMax - height[left]);
                left++;
            }
            else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    trapWater += (rightMax - height[right]);
                right--;
            }
        }
        return trapWater;
    }
}
