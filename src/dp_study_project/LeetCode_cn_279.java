package dp_study_project;

public class LeetCode_cn_279 {
    public int numSquares(int n) {
        if(n < 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j * j <= i;j ++){
                min = Math.min(min,dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
