package jz_offer_studp_project;

public class JZ_cn_101 {

    public boolean canPartition1(int[] nums) {
        if(nums.length  < 2){
            return false;
        }
        int sum = 0;
        for(int i = 0;i < nums.length;i ++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 1;i <= nums.length;i ++){
            for(int j = 0;j <= sum; j ++){
                dp[i][j] = dp[i - 1][j];
                if(!dp[i][j] && j - nums[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];

    }

    //空间压缩
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return false;
        }
        int sum = 0;
        for(int i = 0;i < n;i ++){
            sum+= nums[i];
        }
        if(sum % 2 != 0)return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 1;i < n;i ++){
            for(int j = sum;j >=0;j --){
                if(j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
