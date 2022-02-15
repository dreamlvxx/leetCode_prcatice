package dp_study_project;

public class LeetCode_cn_1746 {
    public int maxSumAfterOperation1(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];

        int res = Math.max(dp[0][0],dp[0][1]);
        for(int i = 1;i < nums.length;i ++){
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i],nums[i]);
            dp[i][1] = Math.max(dp[i - 1][0] > 0?  dp[i - 1][0] + nums[i] * nums[i] : nums[i] * nums[i],dp[i - 1][1] > 0 ? dp[i - 1][1] + nums[i] : nums[i]);
            res = Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }
}
