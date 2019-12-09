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
            if (p.val == q.val) {
                res = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
        return res;
    }
}
