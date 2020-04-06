package leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class LeeCode53 {

    /**
     * dp思路
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(null == nums){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < n; ++ i){
            dp[i] = dp[i - 1] > 0? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
