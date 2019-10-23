package jk;

/**
 * 单链表反转
 */
public class JK06Code1 {
    public class Node {
        public String val;
        Node next;

        public Node(String val) {
            this.val = val;
        }
    }

    //单链表反转
    public Node revertList(Node head) {
        if(null == head){
            return null;
        }
        Node pre = null;
        while (head.next != null) {
            Node temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        head.next = pre;
        return head;
    }

    //单链表反转 递归解法
    public Node revertList1(Node head){
        if (head == null || head.next == null)return head;
        Node res = revertList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
