package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class LeeCode101 {

    public static void main(String[] args) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(null);
        queue.add(null);

        System.out.println(queue);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "-" + val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return true;
        }
        return judge(root.left,root.right);
    }

    public boolean judge(TreeNode left,TreeNode right){
        if(left== null || right == null){
            return left == right;
        }

        if(left.val != right.val){
            return false;
        }

        return judge(left.left,right.right) && judge(left.right,right.left);
    }

}
