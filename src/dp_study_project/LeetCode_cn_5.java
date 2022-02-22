package dp_study_project;

public class LeetCode_cn_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i < n;i ++){
            dp[i][i] = true;
        }
        String res = s.substring(0,1);
        for(int i = 1;i < n;i ++){
            for(int j = 0;j < i;j ++){
                char a = s.charAt(i);
                char b = s.charAt(j);
                if(a == b){
                    if(i - j < 3){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if(dp[j][i] && i - j + 1 > res.length()){
                    res = s.substring(j,i + 1);
                }
            }
        }
        return res;
    }
}
