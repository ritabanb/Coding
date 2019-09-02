package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class UniqueString {
    private boolean isUniqueWithDataStructure(String str) {
        int len = str.length();
        Set<Character> strSet = new HashSet<>();
        for (char ch :  str.toCharArray()) {
            if (strSet.contains(ch))
                return false;
            strSet.add(ch);
        }
        return true;
    }

    private boolean isUniqueWithoutDataStructure(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueString obj = new UniqueString();
        System.out.println(obj.isUniqueWithoutDataStructure("abcdope"));
        System.out.println(obj.isUniqueWithDataStructure("abcdope"));
    }
}
