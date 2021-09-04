package generalImportantProblems;

import java.util.HashMap;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        int min_index = 0;
        int max_index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] < prices[min_index]) {
                min_index = i;
                max_index = i;
                map.put(i, i);
            } else if (prices[i] > prices[max_index] && i > min_index) {
                max_index = i;
                map.put(min_index, i);
            }
        }

      //  System.out.println(map);
        int max = 0;
        for (int temp : map.keySet()) {
            if ((prices[map.get(temp)] - prices[temp]) > max) {
                max = (prices[map.get(temp)] - prices[temp]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock stock = new BestTimeToBuySellStock();
        int[] arr = {7};
        System.out.println(stock.maxProfit(arr));
    }

}
