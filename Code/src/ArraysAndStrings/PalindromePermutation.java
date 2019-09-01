package ArraysAndStrings;

import java.util.Arrays;

public class PalindromePermutation {
    private boolean isPalindromePermutation(String str) {
        int chLen = 256;
        int[] chCount = new int[chLen];
        Arrays.fill(chCount, 0);
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch != ' ')
                chCount[(int)ch]++;
        }
        boolean odd = false;
        for (int count : chCount) {
            if (count % 2 != 0) {
                if (odd)
                    return false;
                odd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePermutation obj = new PalindromePermutation();
        System.out.println(obj.isPalindromePermutation("Tact Coa"));
    }
}
