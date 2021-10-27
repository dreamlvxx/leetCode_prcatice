package dp_study_project;

public class LeetCode_cn_309 {

    /**
     * 首先是在无限次购买的基础上进行改造，
     * 这里的冷冻期，限制的是买入的时机，那么在dp[i][1] 的计算上，买入的时候就必须是dp[i - 2][0]的情况下进行购买。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0,prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0],-prices[1]);
        for(int i = 2;i < n;i ++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

}
