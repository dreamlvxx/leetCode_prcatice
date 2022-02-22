package dp_study_project;

public class LeetCode_cn_300 {
    /**
     * 以i结尾的最大子序列长度
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if(n == 1){
            return 1;
        }
        for(int i = 0;i < n;i ++){
            dp[i] = 1;
        }
        int max = 0;
        for(int i = 1;i < n;i ++){
            for(int j = 0;j < i;j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            System.out.println("dp" + i  + " = " + dp[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
