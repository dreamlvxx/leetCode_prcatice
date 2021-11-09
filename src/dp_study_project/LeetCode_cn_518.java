package dp_study_project;

public class LeetCode_cn_518 {
    /**
     * https://leetcode-cn.com/problems/coin-change-2/solution/dai-ma-sui-xiang-lu-518-ling-qian-dui-hu-q7gm/
     *
     * 这里要分清 【组合】与 【排列】 的区别
     * 组合是不重复的  122
     * 排列是可以重复  212 221 122
     *
     * 组合
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int c : coins){
            for(int i = c;i <= amount;i ++){
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    /**
     * 排列
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 1;i <= amount;i ++){
            for(int j = 0;j < n;j ++){
                if(i - coins[j] >= 0){
                    dp[i] += dp[i - coins[j]];
                }
            }
            System.out.println(dp[i] + "");
        }
        return dp[amount];
    }
}
