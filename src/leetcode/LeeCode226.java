package leetcode;

public class LeeCode226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (null == root) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (null != root.left) {
            invertTree(root.left);
        }
        if (null != root.right) {
            invertTree(root.right);
        }
        return root;
    }
}
