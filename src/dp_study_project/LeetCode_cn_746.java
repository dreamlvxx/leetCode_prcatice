package dp_study_project;

public class LeetCode_cn_746 {
    /**
     * 阶梯对应0 ~ n-1  最后要上去的地方是n，那么就可以从n-1的位置上去，或者从n - 2的位置上去
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null){
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for(int i = 2;i<= n;i ++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
