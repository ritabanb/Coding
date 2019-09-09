package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
//        generate_helper(result, new StringBuilder(), 0, 0, n);
        generate_helper(result, "", 0, 0, n);
        return result;
    }

    public void generate_helper(List<String> list, /*StringBuilder*/String str, int open, int close, int total){

        if(str.length() == (total * 2)){
//            list.add(str.toString());
            list.add(str);
            return;
        }
        if(open < total) {
            generate_helper(list, str + "(", open + 1, close, total);
//            generate_helper(list, str.append("("), open + 1, close, total);
//            str.setLength(str.length() - 1);
        }
        if(close < open) {
            generate_helper(list, str + ")", open, close + 1, total);
//            generate_helper(list, str.append(")"), open, close + 1, total);
//            str.setLength(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        List<String> result = obj.generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
