import java.util.ArrayDeque;

/**
 * 广度优先遍历
 */
public class BFS {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "-" + val;
        }
    }


    public void levelOrderTraversal(TreeNode node){
        if(node==null){
            System.out.print("empty tree");
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node);
        while(!deque.isEmpty()){
            TreeNode rnode = deque.remove();//每次提出来的就是遍历到的元素
            System.out.print(rnode.val+"  ");
            if(rnode.left!=null){
                deque.add(rnode.left);
            }
            if(rnode.right!=null){
                deque.add(rnode.right);
            }
        }
    }

}
