package leetcode;

/**
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class LeeCode121 {
    //solution
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit1(int[] prices) {
        if (null == prices){
            return 0;
        }
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tempMax = prices[i] - prices[j];
                if (tempMax > max){
                    max = tempMax;
                }
            }
        }
        return max;
    }
}
