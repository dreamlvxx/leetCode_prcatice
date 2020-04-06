package offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从[树的根结点开始]往下一直[到叶结点]所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

public class FindPathSumTotarget {

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {//走到null结点 返回即可
            return res;
        }
        find(root, target, new ArrayList<>());
        return res;
    }

    public void find(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> mRes = new ArrayList<>();
        mRes.addAll(list);
        if (root.val > target) {
            return;
        }
        mRes.add(root.val);
        if (root.val == target) {
            if (root.left == null && root.right == null) {
                res.add(mRes);
            }
        }
        find(root.left, target - root.val, mRes);
        find(root.right, target - root.val, mRes);
    }
}
