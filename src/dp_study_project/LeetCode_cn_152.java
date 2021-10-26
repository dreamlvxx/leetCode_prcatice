package dp_study_project;

public class LeetCode_cn_152 {
    /**
     * 因为这里涉及负负得正，所以不再能简单的用前面的乘机跟现在的做对比，
     * 这个时候应该保存俩值，一个最大一个最小，最小可能为负数，当目前的值是正的时候，可能会更大。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1;i < n;i ++){
            if(nums[i] > 0){
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i],nums[i]);
            }else{
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i],nums[i]);
            }
        }
        int max = dp[0][1];
        for(int i = 0;i < n;i ++){
            max = Math.max(max,dp[i][1]);
        }
        return max;
    }
}
