package dp_study_project;

public class LeetCode_cn_343 {
    public int integerBreak(int n) {
        if(n < 2){
            return -1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3;i <= n;i ++){
            for(int j = i;j >=2;j --){
                int max1 = (i - j) * j;
                int max2 = (i - j) *dp[j];
                int max3 = dp[i - j] * j;
                int max4 = dp[i - j] * dp[j];

                int max5 = Math.max(max1,max2);
                int max6 = Math.max(max3,max4);
                int max7 = Math.max(max5,max6);
                dp[i] = Math.max(dp[i],max7);
            }
            System.out.println(dp[i] + "");
        }
        return dp[n];
    }
}
