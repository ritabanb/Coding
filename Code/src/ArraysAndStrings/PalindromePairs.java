package ArraysAndStrings;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> palindromePairs = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                List<Integer> palindrome = new ArrayList<>();
                String str = words[i] + words[j];
                String reverse = new StringBuffer(str).reverse().toString();
                if (str.equals(reverse)) {
                    palindrome.add(i);
                    palindrome.add(j);
                    palindromePairs.add(palindrome);
                }
                palindrome = new ArrayList<>();
                str = words[j] + words[i];
                reverse = new StringBuffer(str).reverse().toString();
                if (str.equals(reverse)) {
                    palindrome.add(j);
                    palindrome.add(i);
                    palindromePairs.add(palindrome);
                }
            }
        }
        return palindromePairs;
    }

    //Leetcode Solution
    public List<List<Integer>> palindromePairs_2(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (words == null) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
        for (int i = 0; i < words.length; ++ i) {
            int l = 0, r = 0;
            while (l <= r) {
                String s = words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                if (r < words[i].length()) ++r;
                else ++l;
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}
