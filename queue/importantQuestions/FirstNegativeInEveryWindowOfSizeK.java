package queue.importantQuestions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        long[] output = new long[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(!deque.isEmpty()&&deque.getFirst()<(i-k+1)){
                while (!deque.isEmpty()&&deque.getFirst()<(i-k+1)){
                    deque.removeFirst();
                }
            }
            if(arr[i]<0)
                deque.addLast(i);

            if(i-k+1>=0){
                if(deque.isEmpty())
                    output[i-k+1] = 0L;
                else
                    output[i-k+1] = arr[deque.getFirst()];
            }

        }
        return output;
    }

    public static void main(String[] args){
        FirstNegativeInEveryWindowOfSizeK obj = new FirstNegativeInEveryWindowOfSizeK();
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(Arrays.toString(obj.printFirstNegativeInteger(arr,arr.length,3)));
    }

}
