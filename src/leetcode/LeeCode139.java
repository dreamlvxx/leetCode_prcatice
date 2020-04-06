package leetcode;

import java.util.Set;

public class LeeCode139 {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        boolean[] f = new boolean[n];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[n - 1];
    }


    public boolean word(String s,Set<String> dict){
        if (null == s){
            return false;
        }

        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (String word :
                    dict) {
                if (word.length() <= i){
                    if (dp[i - word.length()] && dict.contains(s.substring(i - word.length(),i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[length - 1];
    }

}
