import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeeCode094j {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 可以看出来，这个思路其实和广度遍历是类似的。
     * 广度遍历是平铺的进行遍历，而这个中序遍历其实是一个“右斜”的层次遍历，
     * 每一层包括当前节点以及几点的子树。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }


//------------------------------思路是对的，代码没写明白
    public List<Integer> inorderTraversalMine(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        while (cur.right != null || stack.size() != 0 || cur.left != null) {
            if (cur.left != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                res.add(cur.val);
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = stack.pop();
                }
            }
        }
        return res;
    }

}
