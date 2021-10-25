package dp_study_project;

import java.util.ArrayList;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 * https://leetcode-cn.com/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
 */

public class LeetCode_cn_740 {
    public int deleteAndEarn_dp(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal,nums[i]);
        }
        int[] sum = new int[maxVal + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] ++;
        }
        int[] dp = new int[maxVal + 1];
        dp[1] = 1 * sum[1];
        dp[2]  = Math.max(dp[1],2 * sum[2]);
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + i * sum[i]);
        }

        return dp[maxVal];
    }




    //回溯。。会超时======================
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = 0;
        for(int i = 0;i < nums.length;i ++){
            max = Math.max(deleteAndEarn(afterDel(nums,nums[i])) + nums[i],max);
        }
        return max;
    }

    public int[] afterDel(int[] arr, int target){
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + 1 == target || (arr[i] - 1) == target){
                continue;
            }
            res.add(arr[i]);
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}
