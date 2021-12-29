package jz_offer_studp_project;

import java.util.ArrayList;
import java.util.List;

public class JZ_cn_056 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 遍历每个节点，查找是否有匹配的
     */
    List<Integer> list = new ArrayList();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean has = false;
        has = findTarget(root.left, k);
        if (list.contains(k - root.val)) {
            return true;
        } else {
            list.add(root.val);
        }
        has |= findTarget(root.right, k);
        return has;
    }

    /**
     * 可以先全部中序遍历出来，然后双指针
     */
}
