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


    //遍历构造一颗新的树
    TreeNode res = null;
    public TreeNode increasingBST(TreeNode root) {
        res = new TreeNode(-1);
        //假头指针需要记录,最后返回
        TreeNode node = res;
        find(root);
        //假头的下一个就是真头
        return node.right;
    }

    public void find(TreeNode root){
        if(null == root){
            return;
        }
        //左
        find(root.left);
        //中
        //以下两行如果为了不破坏原树结构，可以使用new TreeNode(root.val);
        res.right = root;
        root.left = null;
        //遍历到一个节点就往前走一步
        res = res.right;
        //右
        find(root.right);
    }

}
