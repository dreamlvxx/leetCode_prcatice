package offer;

public class BanlanceTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    boolean isBan = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        dep(root);
        return isBan;
    }

    public int dep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0,right = 0;
        if(root.left != null){
            left = dep(root.left);
        }
        if(root.right != null){
            right = dep(root.right);
        }
        int res = Math.abs(left - right);
        if(res > 1){
            isBan = false;
        }
        return Math.max(left,right) + 1;
    }
}
