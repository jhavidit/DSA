package generalImportantProblems;

public class CircularArray {

    /*
    In circular arrays next index always starts from the mod(%) operator, we can easily access the elements of the circular list
     */

    public static void print(char[] arr, int n, int index) {
        for (int i = index; i < n + index; i++) {
            System.out.print(arr[i % n] + " ");
        }
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        print(arr, arr.length, 3);
    }

}
