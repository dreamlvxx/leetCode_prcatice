package dp_study_project;

public class LeetCode_cn_509 {
    //动态规划
    public int fib_dp(int n) {
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <= n;i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //递归
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
