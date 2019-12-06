package leetcode;

import java.util.Stack;

public class LeeCode872 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(null == root1 || null == root2){
            return true;
        }
        Stack<TreeNode> s1 = new Stack(),s2 = new Stack();
        s1.push(root1);
        s2.push(root2);
        while(!s1.empty() && !s2.empty()){
            if(dfs(s1) != dfs(s2)){
                return false;
            }
        }
        return s1.empty() && s1.empty();
    }

    public int dfs(Stack<TreeNode> stack){
        while(true){
            TreeNode node = stack.pop();
            if(null != node.left){
                stack.push(node.left);
            }
            if(null != node.right){
                stack.push(node.right);
            }
            if(null == node.left && null == node.right){
                System.out.println(node.val);
                return node.val;
            }
        }
    }
}
