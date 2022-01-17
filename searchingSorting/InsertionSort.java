package searchingSorting;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int[] arr = {1, 3, 4, 5, 2};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
