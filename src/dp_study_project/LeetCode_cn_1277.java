package dp_study_project;

public class LeetCode_cn_1277 {
    /**
     * 最大矩形的固定公式
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        if(matrix[0][0] == '1'){
            dp[0][0] = 1;
        }
        int res = 0;
        for(int i = 0;i < m;i ++){
            for(int j = 0;j < n;j ++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res *res;
    }
}
