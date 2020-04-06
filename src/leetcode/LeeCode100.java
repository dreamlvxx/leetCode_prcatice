package leetcode;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class LeeCode100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        boolean res = false;
        if (p != null && q != null) {
            //满足三个条件，root val相等，左子树相同，右子树相同
            if (p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right)) {
                res = true;
            }
        }
        return res;
    }
}
