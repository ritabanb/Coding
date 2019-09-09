package ArraysAndStrings;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int j = 0;
        for (int i = m; i < len; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }
}
