package dp_study_project;

public class LeetCode_cn_343 {
    public int integerBreak(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i <= n;i ++){
            for(int j = 1;j < i;j ++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
