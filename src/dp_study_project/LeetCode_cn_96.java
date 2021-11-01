package dp_study_project;

import java.util.ArrayList;

public class LeetCode_cn_96 {
    /**
     * 首先，这里很重要的一点就是，二叉搜索树
     * 因为数字是从1~n
     * 所以，我们在求i的长度的种树时，
     * 会任选一个节点j作为root
     * 那么左子树肯定是从1-j ,右子树是从j - i
     * 那么我们可以把左子树的种树 * 右子树的种树，也就是当前的所有种树
     * 然后累加以没每个节点为root的情况，即可求出。
     * 这里的dp定义是长度，因为123与456得到的种树时一样的，所以只跟长度有关。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n == 1){
            return 1;
        }
        //dp定义为长度为n的序列可以构成的二叉搜索树的种树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i ++){
            for(int j = 1;j <= i;j ++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
