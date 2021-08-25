package recursion;

public class NumberToWords {


    public static String num(int n) {
        return switch (n) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }

    public static void fun(int n){
        if(n<=0)
            return;
         fun(n/10);
        System.out.print(num(n%10)+" ");
    }

    public static void main(String[] args){
        fun(4310);

    }
}
