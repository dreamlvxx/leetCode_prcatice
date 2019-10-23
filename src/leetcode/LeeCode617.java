package leetcode;

public class LeeCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return Iterator(t1,t2);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode Iterator(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return null;
        }
        TreeNode t;
        if (node1 != null && node2 != null ){
            t = new TreeNode(node1.val + node2.val);
            t.left = Iterator(node1.left,node2.left);
            t.right = Iterator(node1.right,node2.right);
        }else if (node2 != null){
            t = new TreeNode(node2.val);
            t.left = node2.left;
            t.right = node2.right;
        }else {
            t = new TreeNode(node1.val);
            t.left = node1.left;
            t.right = node1.right;
        }
        return t;
    }

}
