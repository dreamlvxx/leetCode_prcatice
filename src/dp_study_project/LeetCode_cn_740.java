package dp_study_project;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */

public class LeetCode_cn_740 {
    /**
     * https://leetcode-cn.com/problems/delete-and-earn/solution/gong-shui-san-xie-zhuan-huan-wei-xu-lie-6c9t0/
     */
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        int[][] dp = new int[max + 1][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0] * 0;
        dp[1][0] = arr[0] * 0;
        dp[1][1] = arr[1] * 1;
        for (int i = 2; i <= max; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i] * i;
            System.out.println(i + " " + dp[i][0] + " " + dp[i][1]);
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}
