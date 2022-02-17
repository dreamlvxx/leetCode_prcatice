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
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i = 1;i <= s.length();i ++){
            for(String word : wordDict){
                int len = word.length();
                if(len <= i){
                    String temp = s.substring(i - len,i);
                    if(temp.equals(word) && dp[i - len]){
                        dp[i] = true;
                        break;
                    }
                }else{
                    dp[i] = false;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * DFS
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return booleanwordBreak_dfs(s, wordDict, 0, visited);
    }

    /**
     * 从前往后匹配，start表示start位置之前的已经匹配，只要保证start往后的继续匹配，就可以了
     * @param s
     * @param wordDict
     * @param start
     * @param visited
     * @return
     */
    public boolean booleanwordBreak_dfs(String s, List<String> wordDict, int start, boolean[] visited) {
        for (String temp : wordDict) {
            int nextStart = start + temp.length();
            if (nextStart > s.length() || visited[nextStart]) continue;

            //这里是从当前start开始往后，查找前缀能否匹配temp，所以并不能使用s.startWith，这个一直都是以0开始匹配
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
     * 从0的位置开始寻找可以继续往后匹配的index，有几个就都push到queue里面，然后从这几个index继续找下一批index，直到出现inedx匹配到s.length()，否则就是无法匹配
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
                        //出口
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
