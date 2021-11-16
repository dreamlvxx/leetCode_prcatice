package leetcode;

/**
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class LeeCode121 {
    //dp解法

    /**
     * 推导状态转移方程：
     * dp[i][0]：规定了今天不持股，有以下两种情况：
     *
     * 昨天不持股，今天什么都不做；
     * 昨天持股，今天卖出股票（现金数增加），
     * dp[i][1]：规定了今天持股，有以下两种情况：
     *
     * 昨天持股，今天什么都不做（现金数与昨天一样）；
     * 昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     * @param prices
     * @return
     */
    public int maxProfit_dp(int[] prices) {
        int res = 0;
        if(null == prices || prices.length == 0){
            return res;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length; i ++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    //第二次
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < n;i ++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
        }
        return dp[n - 1][0];
    }

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

}
