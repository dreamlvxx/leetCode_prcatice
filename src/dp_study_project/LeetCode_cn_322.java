package dp_study_project;

public class LeetCode_cn_322 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for(int i = 1;i <= amount;i ++){
            dp[i] = amount + 1;
        }
        for(int i = 1;i <= amount;i ++){
            for(int j = 0;j < n;j ++){
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i - coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
