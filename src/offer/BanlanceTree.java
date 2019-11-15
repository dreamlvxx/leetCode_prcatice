package offer;

import java.util.HashMap;

public class BanlanceTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    boolean isBan = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        dep(root);
        return isBan;
    }

    public int dep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0,right = 0;
        if(root.left != null){
            left = dep(root.left);
        }
        if(root.right != null){
            right = dep(root.right);
        }
        int res = Math.abs(left - right);
        if(res > 1){
            isBan = false;
        }
        return Math.max(left,right) + 1;
    }


    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr,num1,num2);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0] = -1;
        num2[0] = -1;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < array.length; ++ i){
            map.put(array[i],map.getOrDefault(array[i],0) + 1);
        }
        System.out.println(map);
        for(Integer key : map.keySet()){
            if(map.get(key) == 1){
                if(num1[0] != -1){
                    num1[0] = map.get(key);
                }
                if(num2[0] != -1){
                    num2[0] = map.get(key);
                }
            }
        }
    }
}
