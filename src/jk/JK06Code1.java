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
        if (head == null || head.next == null)return head;//找到最后一个节点
        Node newHead = revertList(head.next);//这个直接从头遍历到最后一个节点了

        head.next.next = head;//将下一个节点的next指向当前
        head.next = null;//把当前的next断开

        return newHead;//其实每次返回的都是这个节点，这个作为新的head，引用关系的改变还是依靠原来的连接
    }

    public Node rever(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = revertList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
