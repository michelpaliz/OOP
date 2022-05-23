package Testing.String;

public class Digit {

    public Digit() {
        String text = "Hello1234";
        String text1 = "H1Ell452";
        String str = "The price of the book is $49";

        // int number = CharMatcher.digit().retainFrom(text);
        // String theDigits = CharMatcher.inRange('0', '9').retainFrom("abc12 3def");
        String regex = "[^0-9]";
        String replacement = "";
        String numberOnly = str.replaceAll("[^0-9]", "");
        String numberOnly2 = text1.replaceAll(regex, replacement);

        System.out.println("This is the number ");
        System.out.println(strToInt(numberOnly2));

    }

    
    public int strToInt(String numStr) {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return num;
    }

}
