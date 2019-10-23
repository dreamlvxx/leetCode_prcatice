import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class Offer04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode res = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {//这个for，是在in中寻找等于pre[0]的值，然后进行分割。
            if (in[i] == pre[0]){
                //以下通过这找到的值，可以将前序，中序中分割出来左子树的前序中序和右子树的前序中序。
                res.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i + 1),Arrays.copyOfRange(in,0,i));
                res.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(in,i + 1,in.length));
                break;
            }
        }
        return res;
    }

    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
//        if(pre == null || in == null){  这里不写null，是因为会出现空数组造成数组越界的异常
//            return null;
//        }
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode res = new TreeNode(pre[0]);
        int i = getIndex(pre,in);
        res.left = reConstructBinaryTree1(Arrays.copyOfRange(pre,1,i + 1),Arrays.copyOfRange(in,0,i));
        res.right = reConstructBinaryTree1(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(in,i + 1,in.length));
        return res;
    }

    public int getIndex(int[] pre,int[] in){
        for(int i = 0;i < pre.length;i ++){
            if(pre[0] == in[i]){
                return i;
            }
        }
        return -1;
    }

}
