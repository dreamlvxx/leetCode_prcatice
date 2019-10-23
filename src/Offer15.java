public class Offer15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        head.next = pre;
        return head;
    }
}
