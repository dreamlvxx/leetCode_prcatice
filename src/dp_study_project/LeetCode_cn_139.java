package dp_study_project;

import java.util.*;

public class LeetCode_cn_139 {
    /**
     * dp解法
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * DFS
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return booleanwordBreak_dfs(s, wordDict, 0, visited);
    }

    public boolean booleanwordBreak_dfs(String s, List<String> wordDict, int start, boolean[] visited) {
        for (String temp : wordDict) {
            int nextStart = start + temp.length();
            if (nextStart > s.length() || visited[nextStart]) continue;

            if (s.indexOf(temp, start) == start) {
                if (nextStart == s.length() || booleanwordBreak_dfs(s, wordDict, nextStart, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        return false;
    }

    /**
     * BFS
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean booleanwordBreak_bfs(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[s.length() + 1];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int start = queue.poll().intValue();
                for (String word : wordDict) {
                    int nextStart = word.length() + start;
                    if (nextStart > s.length() || visited[nextStart]) continue;
                    if (s.indexOf(word, start) == start) {
                        if (nextStart == s.length()) {
                            return true;
                        }
                        queue.add(nextStart);
                        visited[nextStart] = true;
                    }
                }
            }
        }
        return false;
    }

}
