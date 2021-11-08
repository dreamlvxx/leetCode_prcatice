package dp_study_project;

public class LeetCode_cn_300 {
    /**
     * 以i结尾的最大子序列长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2){
            return 1;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for(int i = 1;i < n;i ++){
            dp[i] = 1;
            for(int j = 0;j < i;j ++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
