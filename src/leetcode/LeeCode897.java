package leetcode;

public class LeeCode897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode res = null;
    public TreeNode increasingBST(TreeNode root) {
        res = new TreeNode(root.val);
        TreeNode node = res;
        find(root);
        return node.right;
    }

    public void find(TreeNode root){
        if(null == root){
            return;
        }
        if(null != root.left){
            find(root.left);
        }
        res.right = new TreeNode(root.val);
        res = res.right;
        if(null != root.right){
            find(root.right);
        }
    }

}
