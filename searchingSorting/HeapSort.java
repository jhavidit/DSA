package searchingSorting;

import java.util.Arrays;

public class HeapSort {

    public void heapify(int[] arr, int i, int n) {
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }

    public void heap(int[] arr, int n) {
        for (int i = n / 2-1; i >=0; i--) {
            heapify(arr, i, n);
        }
    }

    public void heapSort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] arr = {5, 2, 4, 3, 1};
        obj.heap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        obj.heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
