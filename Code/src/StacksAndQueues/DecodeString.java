package StacksAndQueues;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> chars = new Stack<>();
        StringBuilder strB = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int startIdx = idx;
                while (Character.isDigit(s.charAt(++idx)));
                count.push(Integer.parseInt(s.substring(startIdx, idx)));
            }
            else if (s.charAt(idx) == '[') {
                chars.push(strB);
                strB = new StringBuilder();
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder ch = strB;
                strB = chars.pop();
                int countCh = count.pop();
                for (int i = 0; i < countCh; i++) {
                    strB.append(ch);
                }
                idx++;
            }
            else {
                strB.append(s.charAt(idx++));
            }
        }
        return strB.toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString("100[leetcode]"));
    }
}
