package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class JZ26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return judgeSubTree(root1, root2) ||
                HasSubtree(root1.left, root2) ||
                HasSubtree(root1.right, root2);
    }

    private boolean judgeSubTree(TreeNode root1, TreeNode root2) { //判断自身结点开始，是否都相同
        if (root2 == null) { // 如果子树先达到 null ，那么一定是其子树
            return true;
        }
        if (root1 == null) {// 父树先到达，不是
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return judgeSubTree(root1.left, root2.left) &&
                judgeSubTree(root1.right, root2.right);
    }

    public boolean isSub(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }

        if (root1.val != root2.val){
            return false;
        }
        return isSub(root1.left,root2.left) && isSub(root1.right,root2.right);
    }
}


