package ArraysAndStrings;

public class OneAway {
    private boolean isOneAway(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        int len1 = str1.length(), len2 = str2.length();
        if (Math.abs(len1 - len2) > 1)
            return false;
        int i = 0, j = 0;
        boolean flag = false;
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (flag)
                    return false;
                flag = true;
                if (len1 > len2)
                    i++;
                else if (len2 > len1)
                    j++;
                else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneAway obj = new OneAway();
        System.out.println(obj.isOneAway("pale", "ple"));
        System.out.println(obj.isOneAway("pales", "pale"));
        System.out.println(obj.isOneAway("pale", "bale"));
        System.out.println(obj.isOneAway("pale", "bake"));
    }
}
