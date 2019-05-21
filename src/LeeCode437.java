import java.util.ArrayList;
import java.util.HashMap;

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

    //算法3 presum + hashMap-----------------------------------------------------------
    public int pathSum3(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);//currSum - target 。sum - k 理解：sum表示从0到当前的sum，那么目的是寻找一个前面的下标，这个下标的从头到它的和，在加上k就等于sum。
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);//每次把当前的值放进去

        res += helper(root.left, currSum, target, preSum);
        res += helper(root.right, currSum, target, preSum);
        // We need to remove it because we reuse the same map in other parts of the tree,
        // which shouldn't see all previous prefixes (Only prefixes from the path should be visible for the current node)
        // 就是说，这个map中存取的值，只是对当前路径而言的，不能牵扯到其他路径。因为有两层递归，左右子树，不可以相互影响。所以每次递归完本节点的下面的树，都要删除当前的map中存的值。
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
