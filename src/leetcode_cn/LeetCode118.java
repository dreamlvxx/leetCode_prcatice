package leetcode_cn;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        result.add(new ArrayList<Integer>() {{
            add(dp[0][0]);
        }});
        if (numRows == 1){
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> res = new ArrayList<>();
            dp[i][0] = 1;
            res.add(dp[i][0]);
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                res.add(dp[i][j]);
            }
            dp[i][i] = 1;
            res.add(dp[i][i]);
            result.add(res);
        }
        return result;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    ls.add(1);
                else {
                    ls.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(ls);
        }
        return list;
    }

}
