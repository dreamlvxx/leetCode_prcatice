package leetcode;

public class LeeCode005 {


    //解法1---暴力解决
    private int lo, maxLen, ri;

    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, ri);
    }

    //判断一个字符串是否回文 从中心向两头扩散
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;//记录一个有效回文串的时候的最左边的边界
            ri = k;//记录一个有效回文串的时候的最右边的边界
            maxLen = k - j - 1;
        }
    }

    /**
     * 动态规划
     * 备忘录功能记录回文子串
     * 也相当于暴力，只不过通过备忘录进行了剪枝
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j + 1 - i > res.length())) {//更新最长
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


}
