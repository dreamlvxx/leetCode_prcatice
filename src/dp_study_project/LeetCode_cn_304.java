package dp_study_project;

public class LeetCode_cn_304 {
    class NumMatrix {
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if(n > 0){
                int m = matrix[0].length;
                dp = new int[n + 1][m + 1];
                for(int i = 1;i <= n;i ++){
                    for(int j = 1;j <= m;j ++){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }
}
