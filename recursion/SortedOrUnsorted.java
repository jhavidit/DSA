package recursion;

public class SortedOrUnsorted {

    public static boolean checkSorted(int[] arr, int index) {
        if (index >= arr.length)
            return true;
        if (arr[index] < arr[index - 1])
            return false;
        return checkSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 2};
        System.out.println(checkSorted(arr, 1));
    }

}
