import java.util.HashSet;
import java.util.Set;

public class LeeCode005 {


    //解法1---暴力解决
    private int lo, maxLen;
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    //判断一个字符串是否回文 从中心向两头扩散
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    //解法2--动态规划--这个类似于KMP中寻找最大前缀子串的思路
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    //mine 失败--- 思路大致相同，但是写不出来精简代码，漏洞比较多，需要加强
    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1)return s;
        String result = "";
        String tworesult = "";
        Set<Character> set = new HashSet<>();
        boolean hasTwo = false;
        int length = s.length();
        if (length == 2){
            if (s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return String.valueOf(s.charAt(0));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        if (set.size() == 1)return s;
        for (int i = 1; i < length - 1; i++) {
            int left = i - 1 , right = i + 1;
            if (!hasTwo){
                if (s.charAt(i) == s.charAt(left)){
                    tworesult = s.substring(left,i + 1);
                    hasTwo = true;
                }
                if (s.charAt(i) == s.charAt(right)){
                    tworesult = s.substring(i,right + 1);
                    hasTwo = true;
                }
            }
            boolean isLast = false;
            while (s.charAt(left) == s.charAt(right)){
                if (left == 0 || right == s.length() - 1){
                    isLast = true;
                    break;
                }
                -- left;
                ++ right;
            }
            if (isLast){
                if ((right - left + 1) > result.length()){
                    result = s.substring(left,right + 1);
                }
            }else{
                ++ left;
                -- right;
                if ((right - left + 1) > result.length()){
                    result = s.substring(left,right + 1);
                }
            }
        }
        String f = result.length() > tworesult.length()? result : tworesult;
        if (f.length() == 0){
            f = String.valueOf(s.charAt(0));
        }
        return f;
    }

    //solution===============================================================


}
