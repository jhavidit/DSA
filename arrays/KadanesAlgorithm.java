package arrays;

public class KadanesAlgorithm {

    public int maxSubArray(int[] arr) {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        for (int j : arr) {
            max_ending_here += j;
            max_so_far = Math.max(max_so_far, max_ending_here);
            max_ending_here = Math.max(max_ending_here, 0);
        }
        return max_so_far;

    }

    public static void main(String[] args) {
        KadanesAlgorithm obj = new KadanesAlgorithm();
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(obj.maxSubArray(arr));

    }

}
