package dp_study_project;

public class LeetCode_cn_392 {
    //DP
    public boolean isSubsequence1(String s, String t) {
        boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for(int i = 0;i <= t.length();i ++){
            dp[i][0] = true;
        }

        for(int i = 1;i <= t.length();i ++){
            for(int j = 1;j <= s.length();j ++){
                if(t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        //预处理
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        //匹配
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

}
