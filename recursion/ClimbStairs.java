package recursion;

public class ClimbStairs {

    public int climb(int n) {

        if (n < 0)
            return 0;
        if (n == 0) {
            return 1;
        }
        return climb(n - 2) + climb(n - 1);
    }

    public static void main(String[] args) {
        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.climb(44));
    }

}
