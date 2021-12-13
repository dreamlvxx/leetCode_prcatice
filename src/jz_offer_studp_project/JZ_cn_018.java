package jz_offer_studp_project;

public class JZ_cn_018 {

    public boolean isPalindrome_index(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left <= right){
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }else{
                char a = Character.toLowerCase(s.charAt(left));
                char b = Character.toLowerCase(s.charAt(right));
                if(a != b){
                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
    }

    //dp
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 1){
            return true;
        }
        // TODO: 2021/12/14 过滤
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i < n;i ++){
            dp[i][i] = true;
        }

        for(int i = 1;i < n;i ++){
            for(int j = 0;j < i;j ++){
                char a = s.charAt(j);
                char b = s.charAt(i);
                if(i - j < 3 && a == b){
                    dp[j][i] = true;
                    continue;
                }
                if(a == b && dp[i - 1][j + 1]){
                    dp[j][i] = true;
                }
            }
        }
        return dp[0][n - 1];
    }
}
