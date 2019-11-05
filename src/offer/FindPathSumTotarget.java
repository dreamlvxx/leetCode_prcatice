package offer;

import java.util.ArrayList;

public class FindPathSumTotarget {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){//走到null结点 返回即可
            return res;
        }
        find(root,target,new ArrayList<>());
        return res;
    }

    public void find(TreeNode root,int target,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        ArrayList<Integer> mRes = new ArrayList<>();
        mRes.addAll(list);
        if(root.val > target){
            return;
        }
        mRes.add(root.val);
        if(root.val == target){
            if(root.left == null && root.right == null){
                res.add(mRes);
            }
        }
        find(root.left,target - root.val,mRes);
        find(root.right,target - root.val,mRes);
    }
}
