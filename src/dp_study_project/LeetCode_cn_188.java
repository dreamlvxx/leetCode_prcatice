package dp_study_project;

public class LeetCode_cn_188 {
    /**
     * 思路同 123题，只不过把2次变成了k次，相当于提取方法。
     * @param k
     * @param prices
     * @return
     */

    public int maxProfit1(int k, int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int n = prices.length;
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        for(int i = 1;i <= k;i ++){
            dp[0][i][0] = MIN_VALUE;
            dp[0][i][1] = MIN_VALUE;
        }

        for(int i = 1;i < n;i ++){
            for(int j = 0;j <= k;j ++){
                //处理一下数组越界(下面有用到 j - 1)
                if(j==0){
                    dp[i][0][0] = 0;
                }else{
                    dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j - 1][1] + prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j][0] - prices[i]);
            }
            dp[i][k][1] = MIN_VALUE;
        }

        int max = 0;
        for(int i = 1;i <= k;i ++){
            max = Math.max(max,dp[n - 1][i][0]);
        }
        return max;
    }
}
