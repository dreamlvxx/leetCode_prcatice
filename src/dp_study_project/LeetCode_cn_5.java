package dp_study_project;

public class LeetCode_cn_5 {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i < n;i ++){
            dp[i][i] = true;
        }

        char[] arr = s.toCharArray();
        int max = 1;
        int begin = 0;
        for(int i = 1;i < n;i ++){
            for(int j = 0;j < i;j ++){
                if(arr[i] == arr[j]){
                    if(i - j < 3){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }else{
                    dp[j][i] = false;
                }
                if(dp[j][i] && i - j + 1 > max){
                    max = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin + max);
    }
}
