package offer;

public class Offer026 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        midNode.next = null;
        l2 = reverseNode(l2);

        while(l2 != null) {
            ListNode temp = l2.next;
            ListNode temp1 = l1.next;

            l2.next = l1.next;
            l1.next = l2;

            l1 = temp1;
            l2 = temp;
        }
    }

    public ListNode getMidNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseNode(ListNode node){
        ListNode pre = null;
        ListNode curr = node;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }
        return pre;
    }

}
