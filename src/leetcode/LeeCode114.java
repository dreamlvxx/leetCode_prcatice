package leetcode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class LeeCode114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode next = null;

    /**
     * 利用从后往前构建
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }
}
