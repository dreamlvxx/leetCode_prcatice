package dp_study_project;

import java.util.List;

public class LeetCode_cn_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < n;i ++){
            for(int j = 0;j < triangle.get(i).size();j ++){
                if(j == 0){
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(j);
                    continue;
                }
                if(j == triangle.get(i).size() - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i ++){
            min = Math.min(dp[n - 1][i],min);
        }
        return min;
    }
}
