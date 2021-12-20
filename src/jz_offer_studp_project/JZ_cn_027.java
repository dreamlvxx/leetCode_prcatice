package jz_offer_studp_project;

public class JZ_cn_027 {

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

    ListNode firstNode;

    public boolean isPalindrome(ListNode head) {
        firstNode = head;
        return lastNode(head);
    }

    public boolean lastNode(ListNode node) {
        if (node == null) {
            return true;
        }
        if (!lastNode(node.next)) {
            return false;
        }
        if (node.val != firstNode.val) {
            return false;
        }
        firstNode = firstNode.next;
        return true;
    }
}
