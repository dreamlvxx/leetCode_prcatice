package dp_study_project;

public class LeetCode_cn_487 {
    /**
     * dp定义为以i为结尾的子数组的最大连续为1的长度。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes_dp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0] == 0 ? 0 : 1;
        dp[0][1] = 1;
        int res = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == 1){
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            else{
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            res = Math.max(res, Math.max(dp[i][1], dp[i][0]));
        }
        return res;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = dp[0];
        for(int i = 1;i < n;i ++){
            if(nums[i] == 1){
                dp[i] = dp[i - 1] + 1;
            }else{
                int curr = 0;
                for(int j = i - 1;j >= 0;j --){
                    if(nums[j] == 1){
                        curr ++;
                    }else{
                        break;
                    }
                }
                dp[i] = curr + 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
