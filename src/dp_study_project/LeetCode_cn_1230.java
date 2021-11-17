package dp_study_project;

public class LeetCode_cn_1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target && j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] * (1 - prob[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j] * (1 - prob[i - 1]) + dp[i - 1][j - 1] * prob[i - 1];
                }
            }
        }
        return dp[n][target];
    }
}
