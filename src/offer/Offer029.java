package offer;

import java.nio.ByteBuffer;

/**
 * https://leetcode.cn/problems/4ueAj6/
 */
public class Offer029 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        Node temp = new Node(insertVal);
        //如果没有节点，自己做一个节点返回
        if(head == null) {
            temp.next = temp;
            return temp;
        }
        int max = head.val;
        Node cur = head.next;
        Node minN = head;
        Node maxN = head;
        while(cur != head){
            if(cur.val >= max) {
                max = cur.val;
                maxN = cur;
            }
            cur = cur.next;
        }
        minN = maxN.next;


        //如果处于最大最小节点的位置，直接插入即可
        if(insertVal >= maxN.val || insertVal <= minN.val) {
            temp.next = minN;
            maxN.next = temp;
            return head;
        }

        //其他情况，直接从minN开始，寻找一个位置插入即可
        cur = minN;
        Node pre = maxN;
        Node next = cur.next;
        while(cur.val < insertVal) {
            pre = cur;
            cur = next;
            next = cur.next;
        }

        temp.next = cur;
        pre.next = temp;
        return head;
    }
}
