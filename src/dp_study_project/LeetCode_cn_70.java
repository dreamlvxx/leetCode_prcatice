package dp_study_project;

public class LeetCode_cn_70 {
    public int climbStairs(int n) {
        if(n <= 0)return 0;
        if(n < 2){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i < n;i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
