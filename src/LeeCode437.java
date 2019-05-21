import java.util.ArrayList;

/**
 *
 */
public class LeeCode437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //----------------------------------算法1 self---
    int all = 0;
    public int pathSum(TreeNode root, int sum) {
        pathChild(root, sum);
        return all;
    }
    //self 利用递归，递归出下层节点的所有路径和，与当前的节点和比较
    private ArrayList<Integer> pathChild(TreeNode root, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.val == sum) {
            all++;
        }
        ArrayList<Integer> rightRsult = pathChild(root.right, sum);
        for (int i = 0; i < rightRsult.size(); i++) {
            int rr = root.val + rightRsult.get(i);
            result.add(rr);
            if (rr == sum) {
                all++;
            }
        }
        ArrayList<Integer> leftResult = pathChild(root.left, sum);
        for (int i = 0; i < leftResult.size(); i++) {
            int ll = root.val + leftResult.get(i);
            result.add(ll);
            if (ll == sum) {
                all++;
            }
        }
        result.add(root.val);
        return result;
    }

    //算法2 ------------------------------------------------------------
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
