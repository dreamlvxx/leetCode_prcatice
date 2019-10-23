package leetcode;

import java.util.ArrayList;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class LeeCode53 {

    public static void main(String[] args) {
        int[] arr = {-2, -1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                hasZero = true;
            }
        }
        //这个最大区域从前往后的总和，从后往前的总和 都是最大的
        int totle = 0;
        int rightIndex = 0;
        int leftIndex = nums.length - 1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            totle += nums[i];
            if (totle > maxSum) {
                rightIndex = i;
                maxSum = totle;
            }

        }
        int totle2 = 0;
        int maxSum2 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            totle2 += nums[i];
            if (totle2 > maxSum2) {
                leftIndex = i;
                maxSum2 = totle2;
            }
        }

        if (leftIndex > rightIndex){
            if (Math.max(maxSum,maxSum2) > 0){

            }
        }

        int result = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 其中的规律是，从头到尾累加的结果，当一连串的数字累加和处于正数的时候，那么就可以继续累加，
     * 但是当一连串的数字累加和处于负数，那么就抛弃之前的这一连串数字
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0]; //这个保存最大值
        int maxEnd = nums[0];//这个是临时存储连续的大于0的最大值的和
        for (int i = 1; i < nums.length; i++) {
            if (maxEnd < 0)maxEnd = 0;//当之前的一连串和小于0的时候，那么就没有累加的资格了，清零
            maxEnd += nums[i];//累加当前的值
            max = Math.max(max,maxEnd);//每次都提升max
        }
        return max;
    }
}
