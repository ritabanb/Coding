package ArraysAndStrings;

import java.util.Arrays;

public class PermutationString {
    private boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        return Arrays.compare(str1Arr, str2Arr) == 0;
    }

    public static void main(String[] args) {
        PermutationString obj = new PermutationString();
        System.out.println(obj.checkPermutation("abch", "hacb"));
    }
}
