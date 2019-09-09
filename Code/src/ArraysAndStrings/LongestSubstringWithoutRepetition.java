package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> charSet = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < len && j < len) {
            if (charSet.contains(s.charAt(j))){
                charSet.remove(s.charAt(i++));
            }
            else {
                charSet.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepetition obj = new LongestSubstringWithoutRepetition();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
