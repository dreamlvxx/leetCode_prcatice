package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode025 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int temp1 = stack1.isEmpty() ? 0 : stack1.pop();
            int temp2 = stack2.isEmpty() ? 0 : stack2.pop();

            int res = temp1 + temp2 + carry;
            carry = res / 10;
            res %= 10;
            ListNode node = new ListNode(res);
            node.next = cur;
            cur = node;
        }
        return cur;
    }

}
