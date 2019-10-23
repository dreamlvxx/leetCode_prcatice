package leetcode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class LeeCode543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        Depth(root);
        return max;
    }

    //类似于求解最大树深度
    public int Depth(TreeNode root) {
        if (null == root) return 0;
        int left = Depth(root.left);
        int right = Depth(root.right);
        if (left + right > max){
            max = left + right;
        }
        return left > right ? left + 1 : right + 1;
    }
}
