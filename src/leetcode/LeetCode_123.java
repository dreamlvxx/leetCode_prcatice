package leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 [两笔]交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 */

public class LeetCode_123 {
    /**
     * lXl@4@1&6
     * dp定义为，第i天，已做了几笔交易(一笔交易指的是买了，卖了)，目前持有还是不持有
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        //因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        int[][][] dp = new int[n][3][2];
        //0的情况首先列出来
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = MIN_VALUE;
        dp[0][1][1] = MIN_VALUE;
        dp[0][2][0] = MIN_VALUE;
        dp[0][2][1] = MIN_VALUE;
        //计算1 ~ n-1 的情况
        for (int i = 1; i < n; i++) {
            //持有，没卖出过 = 昨天持有，今天不动 / 昨天不持有，今天买
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            //持有，卖出过一次 = 昨天的卖出过一次，然后买了一次（持有），今天不动 /  昨天卖出一次，不持有，今天买
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            //持有，卖出过两次(不存在)
            dp[i][2][1] = MIN_VALUE;

            //不持有，没卖出过
            dp[i][0][0] = 0;
            //不持有，卖出过一次 = 昨天卖出过一次，不持有，今天不动 / 昨天持有，今天卖出
            dp[i][1][0] = Math.max(dp[i - 1][1][0],dp[i - 1][0][1] + prices[i]);
            //不持有，卖出过两次 = 昨天卖出过一次，持有，今天卖出 / 昨天卖出过两次，今天不动
            dp[i][2][0] = Math.max(dp[i - 1][2][0],dp[i - 1][1][1] + prices[i]);
        }
        //最后判断最大值，手中应该是不持有
        return Math.max(0, Math.max(dp[n - 1][2][0], dp[n - 1][1][0]));
    }

    //第二次
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = MIN_VALUE;
        dp[0][1][1] = MIN_VALUE;
        dp[0][2][0] = MIN_VALUE;
        dp[0][2][1] = MIN_VALUE;

        for(int i = 1;i < n;i ++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1],dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0],dp[i - 1][0][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1],dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0],dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = MIN_VALUE;
        }
        return Math.max(Math.max(dp[n - 1][1][0],dp[n - 1][2][0]),0);
    }
}
