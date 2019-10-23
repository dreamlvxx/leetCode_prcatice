package leetcode;

public class LeeCode104 {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int left = 1;
        int right = 1;
        if (null != root.left) {
            left += maxDepth(root.left);
        }
        if (null != root.right) {
            right += maxDepth(root.right);
        }
        return Math.max(left, right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
