/**
 * 求解一颗树的最大深度
 */
public class TreeMaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMaxDepth(TreeNode root) {
        if (null == root) return 0;
        int leftHeight = getMaxDepth(root.left);
        int rightHeight = getMaxDepth(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
