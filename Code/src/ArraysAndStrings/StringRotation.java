package ArraysAndStrings;

public class StringRotation {
    private boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    private boolean isRotation(String str1, String str2) {
        return (isSubstring(str1 + str1, str2));
    }

    public static void main(String[] args) {
        StringRotation obj = new StringRotation();
        System.out.println(obj.isRotation("waterbottle", "erbottlewat"));
    }
}
