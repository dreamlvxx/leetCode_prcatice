package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
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

    //利用BFS 和 stack对称消除 没写出来。待完成。
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                if (stack.peek() == null){
                    stack.pop();
                }else{
                    stack.push(temp);
                }
                continue;
            }
            if (!stack.isEmpty()) {
                if (null != stack.peek()){
                    if (stack.peek().val == temp.val){
                        stack.pop();
                    }else{
                        stack.push(temp);
                    }
                }else{
                    stack.pop();
                }
            } else {
                stack.push(temp);
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return stack.pop() == root;
    }
}
