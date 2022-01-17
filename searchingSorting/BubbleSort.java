package searchingSorting;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int[] arr = {5, 3, 2, 4, 1};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
