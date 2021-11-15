package dp_study_project;

import java.util.Arrays;

public class LeetCode_cn_213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robInner(Arrays.copyOfRange(nums,0,nums.length - 1)),robInner(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int robInner(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i  = 2;i < nums.length;i ++){
            dp[i] = Math.max(dp[i-1],dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    //第二次
    public int ro2b(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robInner(Arrays.copyOfRange(nums,0,nums.length - 1)),robInner(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int robInner2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i  = 2;i < nums.length;i ++){
            dp[i] = Math.max(dp[i-1],dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
