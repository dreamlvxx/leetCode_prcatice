package dp_study_project;

public class LeetCode_cn_746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null){
            return 0;
        }
        int n = cost.length;
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return Math.max(cost[0],cost[1]);
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.min(cost[0],cost[1]);
        for(int i = 2;i< n;i ++){
            dp[i] = Math.min(dp[i - 1] + cost[i],dp[i - 2] + cost[i - 1]);
        }
        return dp[n - 1];
    }
}
