package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            }
            else if (map.containsValue(ch)) {
                if (!stack.empty() && map.get(stack.peek()) == ch)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("}"));
    }
}
