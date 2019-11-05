package offer;

public class ConvertTreeToSequenceTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        //当前结点为null，返回null
        if(pRootOfTree == null){
            return null;
        }
        //当前结点不是null，但是没有子树，就是叶子结点，返回叶子
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //处理左子树
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode res = left;
        while(res != null && res.right != null){
            res = res.right;
        }
        if(left != null){
            res.right = pRootOfTree;
            pRootOfTree.left = res;
        }
        //处理右子树
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null? pRootOfTree : left;
    }
}
