package ArraysAndStrings;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int max = 0;
        while (left < right) {
            if (height[left] > height[right])
            {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
            else {
                max = Math.max(max, height[left] * (right - left));
                left++;
            }
        }
        return max;
    }
}
