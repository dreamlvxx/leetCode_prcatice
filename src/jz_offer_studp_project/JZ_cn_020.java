package jz_offer_studp_project;

public class JZ_cn_020 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                char a = s.charAt(i);
                char b = s.charAt(j);

                if (a == b) {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i]) {
                    res++;
                }
            }
        }
        return res;
    }
}
