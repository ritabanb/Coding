package ArraysAndStrings;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        int left = 0, right = len - 1, mid = 0;
        int rot = 0;
        if (nums[left] >= nums[right]) {
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    rot = mid + 1;
                    break;
                }
                else {
                    if (nums[mid] >= nums[left])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }
        if (target == nums[rot])
            return rot;
        if (rot == 0) {
            left = 0;
            right = len - 1;
        }
        else if (target >= nums[0]) {
            left = 0;
            right = rot;
        }
        else {
            left = rot;
            right = len - 1;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        int[] arr = {3, 1};
        System.out.println(obj.search(arr, 3));
    }
}