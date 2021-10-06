package searchingSorting;

import java.util.Arrays;

public class FindPairGivenDifference {

    public boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            int index = Arrays.binarySearch(arr, n + arr[i]);
            if (index != i && index >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindPairGivenDifference obj = new FindPairGivenDifference();
        int[] arr = {5, 20, 3, 2, 5, 80};
        System.out.println(obj.findPair(arr, arr.length, 45));
    }

}
