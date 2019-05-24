/**
 *
 */
public class LeeCode206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    ListNode neNode = null;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            neNode = head;
            return head;
        }
        reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return neNode;
    }


    /**
     * 循环实现
     * @param head
     * @return
     */
    ListNode nnNode = null;
    public ListNode reverseList1(ListNode head) {
        while (head != null){
            ListNode temp = head.next;
            head.next = nnNode;
            nnNode = head;
            head = temp;
        }
        return nnNode;
    }

}
