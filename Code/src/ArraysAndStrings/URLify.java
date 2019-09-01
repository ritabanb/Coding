package ArraysAndStrings;

public class URLify {
    private String urlify(String str, int len) {
        return str.substring(0, len).replace(" ", "%20");
    }

    public static void main(String[] args) {
        URLify obj = new URLify();
        System.out.println(obj.urlify("Mr John Smith", 13));
    }
}
