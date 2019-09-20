package ArraysAndStrings;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] tempArr = nums1;
            nums1 = nums2;
            nums2 = tempArr;
            int tmp = len1;
            len1 = len2;
            len2 = tmp;
        }
        int iMin = 0, iMax = len1;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = ((len1 + len2 + 1) / 2) - i;
            if (i < iMax && nums2[j-1] > nums1[i])
                iMin = i + 1;
            else if (i > iMin && nums1[i-1] > nums2[j])
                iMax = i - 1;
            else {
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j-1];
                else if (j == 0)
                    maxLeft = nums1[i-1];
                else
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if ((len1 + len2) % 2 == 1)
                    return maxLeft;

                int minRight = 0;
                if (i == len1)
                    minRight = nums2[j];
                else if (j == len2)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums2[j], nums1[i]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
