package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 树的非递归遍历
 */
public class TreeNodeTravelByIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历 - 中左右
     *
     * @param root
     */
    public List<Integer> preTrack(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return res;
    }

    /**
     * 后序遍历 --左右中
     * 后序遍历就是前序遍历然后reverse一下
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }


    /**
     * 中序遍历--左中右
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        //递归与迭代的区别就是递归隐式维护了一个栈，此处我们就模拟这个栈
        Stack<TreeNode> stack = new Stack<>();
        // cur 只是标记的right节点，所以不会造成回退现象
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (root!=null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return  res;
    }

    public List<Integer> inorderTrack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (!stack.isEmpty() && cur != null){
            //找到最左边节点，之前的节点进栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //跳出循环之后，表明左子树没有了，那么现在就剩root节点和right子树了
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

}
