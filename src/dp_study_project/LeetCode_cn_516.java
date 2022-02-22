package dp_study_project;

public class LeetCode_cn_516 {
    public int longestPalindromeSubseq1(String s) {
        /*
            bb aa bb
            bb a  bb
            dp[i][j] 表示 第 i 个字符到 第 j 个字符之间最长的回文子序列长度
            1、当 s[i] == s[j] 时，考虑 i 和 j 中间序列的奇偶个数， dp[i][j] = dp[i+1][j-1] + 2
            对上述 dp[i][j] =  dp[i+1][j-1] + 2 的解释：
            当序列为 b aa b 时， i = 0, j = 3，则 dp[0][3] = dp[1][2] + 2 = 4
            当序列为 b a b 时，i = 0, j = 2，则 dp[0][2] = dp[1][1] + 2 = 3
            当序列为 b b 时， i = 0, j = 1，则 dp[0][1] = dp[1][0] = 0 + 2 = 2 (dp[1][0] 默认值为 0)
            该式子同时考虑到了奇偶
            2、当 s[i] != s[j] ，那么 dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])
            对上述 dp[i][j] 式子的解释：
            假如序列为 d c b c c（index：0-4），s[0] != s[4] ，则 dp[0][4] = Math.max(dp[0][3],dp[1,4]) = Math.max(2,3) = 3

            注意：上述按我习惯分析是将 i 放在了 j 的前面，而按我写法习惯这里是将 i 放在了 j 的后面，即上面的 dp[i][j] 在这里应该是 dp[j][i]
            两层 for 循环，令 i 从 0 遍历到 len-1，而 j 为 i-1 递减到 0
            假如 i = 5，那么 j 的顺序为 4 3 2 1 0，在得到 dp[0][5] 过程中，dp[1][5]等值 就已经提前准备好了，有预先值
            一个字符单独作为一个回文子序列，即 dp[i][i] = 1
        */

        /**
         * 首先要看base在那里
         * 这里的base是dp[i][i]
         */

        int len = s.length();
        int[][] dp = new int[len][len];

        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    dp[j][i] = dp[j+1][i-1] + 2;
                }else{
                    dp[j][i] = Math.max(dp[j+1][i],dp[j][i-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
