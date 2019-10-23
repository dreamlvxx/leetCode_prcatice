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
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    //递归的返回值 不同处理
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList();
        if(listNode != null){
            res = printListFromTailToHead1(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }
}
