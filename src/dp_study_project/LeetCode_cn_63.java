package dp_study_project;

public class LeetCode_cn_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
            if(obstacleGrid[0][0] == 1){
                return 0;
            }else{
                return 1;
            }
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 1;i < m;i ++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 1;i < n;i ++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 1;i < m;i ++){
            for(int j = 1;j < n;j ++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                if(obstacleGrid[i - 1][j] != 1){
                    dp[i][j] += dp[i - 1][j];
                }
                if(obstacleGrid[i][j - 1] != 1){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
