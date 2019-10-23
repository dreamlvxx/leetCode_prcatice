package leetcode;

import java.util.HashMap;

/**
 * 删除倒数第几个结点
 */
public class LeeCode19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        HashMap<Integer,ListNode> help = new HashMap<>();
        int index = 0;
        while (head != null){
            help.put(++index ,head);
            head = head.next;
        }
        ListNode pre = help.get(help.size() - n);
        if (pre == null){
            res = res.next;
        }else{
            pre.next = pre.next.next;
        }
        return res;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
