package dp_study_project;

public class LeetCode_cn_931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i ++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1;i < n;i ++){
            for(int j = 0;j < n;j ++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j + 1]) + matrix[i][j];
                    continue;
                }
                if(j == n - 1){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + matrix[i][j];
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i - 1][j]),dp[i - 1][j + 1]) + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < n;i ++){
            System.out.println(dp[n - 1][i] + "");
            res = Math.min(res,dp[n - 1][i]);
        }
        return res;

    }
}
