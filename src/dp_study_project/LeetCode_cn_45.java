package dp_study_project;

public class LeetCode_cn_45 {
    //动态规划
    public int jump_dp(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] + j >= i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    //贪心
    public int jump(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int minStep = 0;
        int end = 0;
        int nextEnd = 0;

        for(int i = 0;i < nums.length - 1;i ++){
            nextEnd = Math.max(nextEnd,i + nums[i]);
            if(i == end){
                end = nextEnd;
                minStep ++;
            }
        }
        return minStep;
    }

}
