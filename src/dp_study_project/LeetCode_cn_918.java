package dp_study_project;

import java.util.Arrays;

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
    public int maxSubarraySumCircular_dp(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int all = 0;
        int n = nums.length;
        for(int i = 0;i < n;i ++){
            all += nums[i];
        }

        int[] center = Arrays.copyOfRange(nums,1,nums.length - 1);
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[center.length];
        dpMax[0] = nums[0];
        dpMin[0] = center[0];
        for(int i = 1;i < nums.length;i ++){
            dpMax[i] = Math.max(dpMax[i - 1],0) + nums[i];
        }
        for(int i = 1;i < center.length;i ++){
            dpMin[i] = Math.min(dpMin[i - 1],0) + center[i];
        }

        int resMax = Integer.MIN_VALUE;
        int resMin = Integer.MAX_VALUE;
        for(int i = 0;i < n;i ++){
            resMax = Math.max(resMax,dpMax[i]);
        }
        for(int i = 0;i < center.length;i ++){
            resMin = Math.min(resMin,dpMin[i]);
        }

        return Math.max(resMax,all - resMin);
    }

}
