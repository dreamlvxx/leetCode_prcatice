package jz_offer_studp_project;

public class JZ_cn_052 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 其实很简单，就是一个中序遍历，然后遍历到每一个节点的时候，拿这个节点去构造新的tree就好了。
     */
    TreeNode res;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        res = new TreeNode(-1);
        TreeNode temp = res;
        travel(root);
        return temp.right;
    }

    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        res.right = new TreeNode(root.val);
        res = res.right;
        travel(root.right);
    }
}
