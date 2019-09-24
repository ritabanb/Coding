package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    private Map<String, String> phone;
    private List<String> combinations;

    private void letterCombinationsHelper(String comb, String currDigits) {
        if (currDigits.length() == 0) {
            combinations.add(comb);
            return;
        }
        String phoneLetters = phone.get(currDigits.substring(0, 1));
        for (char ch : phoneLetters.toCharArray()) {
            letterCombinationsHelper(comb + ch, currDigits.substring(1));
        }
    }

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.equals(""))
            return combinations;
        phone = new HashMap<String, String>();
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
        letterCombinationsHelper("", digits);
        return combinations;
    }
}
