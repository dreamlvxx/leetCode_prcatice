package offer;

import java.util.LinkedList;
import java.util.Stack;

public class Offer18 {

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归
    public void Mirror1(TreeNode root){
        if (root == null)return;
        //reverse
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归
        Mirror1(root.left);
        Mirror1(root.right);
    }


    //非递归   利用层次遍历原理  借助queue
    public void Mirror(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //get
            TreeNode node = queue.remove();

            //reverse
            TreeNode temp = node.left;
            node.right = node.left;
            node.left = temp;

            //put
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
    }


    //因为和层次遍历不同，可以先处理左子树，再处理右子树，所以可以利用栈。
    public void Mirror2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return;
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
    }


}
