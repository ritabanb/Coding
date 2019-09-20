package ArraysAndStrings;

public class IntegerToEnglishWords {
    private final String[] lessThanTen = new String[]
            {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] lessThanTwenty = new String[]
            {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] lessThanHundred = new String[]
            {"", "Ten", "Twenty", "Thirty", "Forty",
                    "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        return number2Words(num);
    }

    private  String number2Words(int num){
        String result = new String();
        if (num < 10)
            result = lessThanTen[num];
        else if (num < 20)
            result = lessThanTwenty[num -10];
        else if (num < 100)
            result = lessThanHundred[num/10] + " " + number2Words(num % 10);
        else if (num < 1000)
            result = number2Words(num/100) + " Hundred " +  number2Words(num % 100);
        else if (num < 1000000)
            result = number2Words(num/1000) + " Thousand " +  number2Words(num % 1000);
        else if (num < 1000000000)
            result = number2Words(num/1000000) + " Million " +  number2Words(num % 1000000);
        else
            result = number2Words(num/1000000000) + " Billion " + number2Words(num % 1000000000);
        return result.trim();
    }
}
