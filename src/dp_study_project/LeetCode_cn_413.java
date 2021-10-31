package dp_study_project;

public class LeetCode_cn_413 {

    /**
     * dp定义为以i结尾的序列有几个等差数列
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices1(int[] nums){
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i < n;i ++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 0;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dp[i];
        }
        return res;
    }

    /**
     * dp定义为以i结尾的是否为等差数列
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = false;
        dp[1] = false;
        int res = 0;
        for(int i = 2;i < n;i ++){
            if(nums[i] - nums[i - 1]  == nums[i - 1] - nums[i - 2]){
                dp[i] = true;
                res ++;
                int j = 1;
                while(i - j >= 1 && dp[i - j]){
                    res ++;
                    j ++;
                }
            }
        }
        return res;
    }
}
