package offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class JZ54 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
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

    //===============
    public ListNode findlas(ListNode head,int k){
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k > 1){
            fast = fast.next;
            if (fast == null){
                return null;
            }
            k--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
