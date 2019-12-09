package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) {
            return result;
        }
        if (null == root.left && null == root.right) {
            result.add("" + root.val);
        } else {
            find(root.left, "" + root.val);
            find(root.right, "" + root.val);
        }
        return result;
    }

    public void find(TreeNode root, String temp) {
        if (null == root) {
            return;
        }
        temp += "->";
        temp += root.val;
        if (null == root.left && null == root.right) {
            result.add(temp);
        } else {
            find(root.left, temp);
            find(root.right, temp);
        }
    }
}
