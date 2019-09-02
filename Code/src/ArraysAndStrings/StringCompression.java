package ArraysAndStrings;

public class StringCompression {
    private String stringCompression(String str) {
        int len = str.length();
        int count = 1, i = 0;
        char ch = str.charAt(i++);
        StringBuilder result = new StringBuilder();
        boolean unique = true;
        while (i < len) {
            if (ch == str.charAt(i))
                count++;
            else {
                if (unique && count > 1)
                    unique = false;
                result.append(ch).append(count);
                ch = str.charAt(i);
                count = 1;
            }
            i++;
        }
        if (unique && count > 1)
            unique = false;
        result.append(ch).append(count);
        if (unique)
            return str;
        return result.toString();
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        System.out.println(obj.stringCompression("aabcccccaaa"));
        System.out.println(obj.stringCompression("abcda"));
    }
}
