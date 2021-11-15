package dp_study_project;

public class LeetCode_cn_918 {

    /**
     * 根据题解可知：
     * 环形子数组的最大和具有两种可能
     * >>不使用环的情况
     * 不使用环的情况时，直接通过53题的思路，逐步求出整个数组中的最大子序和即可
     * >>使用环的情况
     * 使用到了环，则必定包含 A[n-1]和 A[0]两个元素且说明从A[1]到A[n-2]这个子数组中必定包含负数
     * 【否则只通过一趟最大子序和就可以的出结果】
     * 因此只需要把    A[1]~A[n-2]    间这些负数的最小和求出来
     * 用整个数组的和 sum减掉这个负数最小和即可实现原环型数组的最大和
     *
     **/
    public int maxSubarraySumCircular(int[] A) {
        int[] dp = new int[A.length];   //dp[i]用来记录以nums[i]结尾的最大子序列和
        dp[0] = A[0];                   //初始化dp
        int max = dp[0];                //最大子序列和
        int sum = dp[0];                //整个数组的和

//        求最大子序列和，见53题
        for (int i = 1; i < dp.length; i++) {
            sum += A[i];
            dp[i] = A[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
        }

        int min = 0;    //开始求A[1]~A[n-1]上的最小子序列和
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i] = A[i] + Math.min(0, dp[i - 1]);
            min = Math.min(dp[i], min);
        }
        return Math.max(sum - min, max);
    }

    public int maxSubarraySumCircular_dp(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i < n;i ++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i < n;i ++){
            maxValue = Math.max(maxValue,dp[i]);
        }

        int[] dpMin = new int[n];
        dpMin[0] = nums[0];
        for(int i = 1;i < n - 1;i ++){
            if(dpMin[i - 1] < 0){
                dpMin[i] = dpMin[i - 1] + nums[i];
            }else{
                dpMin[i] = nums[i];
            }
        }
        int minValue = 0;
        for(int i = 1;i < n - 1;i ++){
            minValue = Math.min(minValue,dpMin[i]);
        }

        int sum = 0;
        for(int i = 0;i < n;i ++){
            sum += nums[i];
        }

        return Math.max(maxValue,sum - minValue);
    }

}
