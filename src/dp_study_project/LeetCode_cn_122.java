package dp_study_project;

public class LeetCode_cn_122 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < n;i ++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
