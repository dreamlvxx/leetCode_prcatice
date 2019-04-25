/**
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree
 * such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 */
public class LeeCode538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (null == root) return null;
        convert(root);
        return root;
    }

    /**
     * 相当于RTL遍历，值越来越大,当前值加上之前的总和即可
     */
    int sum = 0;
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);//右
        cur.val += sum;//根
        sum = cur.val;//记录遍历过的node的值和
        convert(cur.left);//左
    }

}
