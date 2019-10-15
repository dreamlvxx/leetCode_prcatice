import java.util.ArrayList;

/**
 * 从尾到头打印一个二叉树，
 */
public class Offer02 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归实现
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode);
            res.add(listNode.val);
        }
        return res;
    }
}
