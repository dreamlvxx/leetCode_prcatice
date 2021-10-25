package dp_study_project;

public class LeetCode_cn_55 {
    //贪心
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return true;
        }
        int max = 0;
        for(int i = 0;i < nums.length; i ++  ){
            if(i <= max){
                max = Math.max(max,i + nums[i]);
            }
            if(max >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    //动态规划
    public boolean canJump_dp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && j + nums[j] >= i){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

}
