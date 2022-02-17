package dp_study_project;

public class LeetCode_cn_188 {
    /**
     * 思路同 123题，只不过把2次变成了k次，相当于提取方法。
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        for(int i = 1;i <= k;i ++){
            dp[0][i][0] = MIN_VALUE;
            dp[0][i][1] = MIN_VALUE;
        }

        for(int i = 1;i < prices.length;i ++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1],dp[i - 1][0][0] - prices[i]);
            for(int j = 1;j <= k;j ++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j][0] - prices[i]);
            }
        }

        int res = MIN_VALUE;
        for(int i = 0;i <= k;i ++){
            res = Math.max(res,dp[prices.length - 1][i][0]);
        }
        return res;
    }
}
