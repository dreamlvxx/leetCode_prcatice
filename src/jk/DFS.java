package jk;
import java.util.Stack;

public class DFS {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //遍历解决
    public void dfs(TreeNode root){

        if(null == root)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if (temp.left != null){
                stack.add(temp.left);
            }
            if (temp.right != null){
                stack.add(root.right);
            }
        }
    }
}
