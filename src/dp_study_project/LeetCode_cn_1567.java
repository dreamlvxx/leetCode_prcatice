package dp_study_project;

public class LeetCode_cn_1567 {
    public int getMaxLen(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        if(nums[0] > 0){
            dp[0][0] = 0;
            dp[0][1] = 1;
        }else if(nums[0] < 0){
            dp[0][0] = 1;
            dp[0][1] = 0;
        }
        int maxLength = dp[0][1];
        for(int i = 1;i < n;i ++){
            if(nums[i] > 0){
                dp[i][0] = dp[i - 1][0] > 0? dp[i - 1][0] + 1 : 0;
                dp[i][1] = dp[i - 1][1] + 1;
            }else if(nums[i] < 0){
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] > 0? dp[i - 1][0] + 1 : 0;
            }else{
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            maxLength = Math.max(maxLength,dp[i][1]);
        }
        return maxLength;
    }
}
