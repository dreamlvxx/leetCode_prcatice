package dp_study_project;

public class LeetCode_cn_416 {
    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
     * <p>
     * 且需要注意的是第二层的循环我们需要从大到小计算，因为如果我们从小到大更新 dp 值，
     * 那么在计算 dp[j] 值的时候，dp[j−nums[i]] 已经是被更新过的状态，不再是上一行的 dp 值。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    /**
     * 下面这种为什么不行
     * 从迭代来看，如果以sum的值为第一层，那么第一层选过的数字，第二次迭代，还是会重复选择那个数字，所以不太对
     * 如果以nums为第一层，那么每次都是多加一个nums最后一个数字，不会存在重复选择的情况
     * @param nums
     * @return
     */
    public boolean canPartition_error(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;


        for(int i = 1;i <= sum;i ++){
            for(int j = 0;j < nums.length;j ++){
                if(i - nums[j] >= 0){
                    dp[i] = dp[i - nums[j]];
                    if(dp[i]){
                        break;
                    }
                }
            }
            System.out.println(i + " " + dp[i]);
        }
        return dp[sum];
    }
}
