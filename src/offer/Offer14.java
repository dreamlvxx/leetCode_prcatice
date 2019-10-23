package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Offer14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        if(k == 0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(k > 1){
            fast = fast.next;
            if(fast == null){
                return null;
            }
            k--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
