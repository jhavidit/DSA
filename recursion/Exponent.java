package recursion;

public class Exponent {

    public static int exp(int n, int pow) {
        if (pow == 0)
            return 1;
        return n * exp(n, pow - 1);
    }


    /*
    Fast Exponentiation
    Time complexity - O(logn)
     */
    public static int Exp(int n, int pow) {
        if (pow == 0)
            return 1;
        int ans = exp(n, pow / 2);
        if (pow % 2 == 0) {
            return ans * ans;
        } else {
            return n * ans * ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Exp(3, 3));
    }

}
