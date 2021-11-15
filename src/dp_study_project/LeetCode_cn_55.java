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

    //第二次 正向填充 从当前可以跳到后面的的位置进行填充
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 0;i < n;i ++){
            if(dp[i]){
                for(int j = 1;j <= nums[i];j ++){
                    if(j + i == n){
                        return true;
                    }
                    dp[j + i] = true;
                }
            }else{
                return false;
            }
        }
        return dp[n - 1];
    }

}
