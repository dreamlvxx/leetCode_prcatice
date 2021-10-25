package dp_study_project;

public class LeetCode_cn_53 {
    /**
     * 这里的关键是要想明白，只要dp[i - 1] 是大于0 的，那么加上当前值一定会更大。所以可以以i结尾的字数组来定义dp
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i < n;i ++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i < n;i ++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
