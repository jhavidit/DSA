package recursion;

public class NumberToWords {


    public static String num(int n) {
        switch (n) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    public static void fun(int n) {
        if (n <= 0)
            return;
        fun(n / 10);
        System.out.print(num(n % 10) + " ");
    }

    public static void main(String[] args) {
        fun(4310);

    }
}
