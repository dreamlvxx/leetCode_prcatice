package offer;

import java.util.HashMap;

/**
 * 输入一棵二叉搜索树，将该【二叉搜索树】转换成一个【排序】的【双向】链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTreeToSequenceTree {
    public class TreeNode {
        int val;
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
        //因为最后一行返回的是left，所以并不是已经构建好的链表的最后一个节点，所以需要找到最后一个节点，然后拼接root和right
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
        System.out.println("left node val = " + left.val);
        //这里返回的left，其实每次都一样，所以这个递归出来就是每次拼接上了root，和right的链表，然后返回
        return left == null? pRootOfTree : left;
    }


    //直接用中序遍历(未看)
    public class Solution {
        TreeNode head = null;
        TreeNode realHead = null;
        public TreeNode Convert(TreeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private void ConvertSub(TreeNode pRootOfTree) {
            if(pRootOfTree==null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
    }
}
