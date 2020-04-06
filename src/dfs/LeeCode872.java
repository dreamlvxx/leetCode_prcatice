package dfs;

public class LeeCode872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root1,sb1);
        dfs(root2,sb2);
        return sb1.toString().equals(sb2.toString());
    }

    public void dfs(TreeNode root,StringBuilder sb) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            sb.append(root.val + "-"); //这里特意加了一个-，是为了防止7  14  ，71 4  这种组合起来看起来一样，
        }
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
}
