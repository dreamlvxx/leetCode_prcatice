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

    //第二次
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i < n;i ++){
            dp[i] = nums[i];
            if(dp[i - 1] > 0){
                dp[i] = Math.max(dp[i],dp[i - 1] + nums[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i ++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
