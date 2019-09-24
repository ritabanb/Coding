package Miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while(sumSet.add(n)) {
            int temp = n;
            int sum = 0;
            while (temp > 0) {
                sum += (temp % 10) * (temp % 10);
                temp = temp / 10;
            }
            if (sum == 1)
                return true;
            n = sum;
        }
        return false;
    }
}
