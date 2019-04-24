public class LeeCode002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)return null;
        ListNode st = new ListNode(0);
        //当需要一个链表，返回头部指针的时候。那么操作这个链表的时候，用另外一个指针指向头部，进行操作。
        ListNode newListNode = st;
        int bring = 0;
        while (l1 != null || l2 != null){
            //对于两个链表长度不一致，短的那个相当于用0补充
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            int sum = bring + x + y;
            bring = sum / 10;
            newListNode.next = new ListNode(sum % 10);
            newListNode = newListNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (bring == 1){
            newListNode.next = new ListNode(1);
        }
        //这种需要初始化链表头的，但是链表头没用，可以返回header.next即可。
        return st.next;
    }
}
