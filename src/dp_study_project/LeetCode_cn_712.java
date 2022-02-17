package dp_study_project;

public class LeetCode_cn_712 {
    public static void main(String[] args) {
        int a = 1 + 'a';
        System.out.println("" + a);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1;i <= n;i ++){
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1) - 'a' + 97;
        }
        for(int j = 1;j <= m;j ++){
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1) - 'a' + 97;
        }
        for(int i = 1;i <= n;i ++){
            for(int j = 1;j <= m;j ++){
                char a = s1.charAt(i - 1);
                char b = s2.charAt(j - 1);
                if(a == b){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j] + (a - 'a' + 97),dp[i][j - 1] + (b - 'a' + 97));
                }
            }
        }
        return dp[n][m];
    }
}
